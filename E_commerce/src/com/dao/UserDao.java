package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import com.bean.UserBean;
import com.util.DBConnection;

public class UserDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	public boolean registerUser(UserBean user) throws SQLException {
		String query = "INSERT INTO users (email, username, password, role) VALUES (?, ?, ?, ?)";
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
			pstmt.setString(4, user.getRole());
			
			return (pstmt.executeUpdate() == 1) ? true: false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public UserBean validateUser(String username, String password) {
		String query = "SELECT * FROM users WHERE username = ?";
		UserBean user = null;
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String storedHash = rs.getString("password");
				
				if(BCrypt.checkpw(password, storedHash)) {
					user = new UserBean();
					user.setUser_id(rs.getInt("user_id"));
					user.setUsername(rs.getString("username"));
					user.setRole(rs.getString("role"));
					return user;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}