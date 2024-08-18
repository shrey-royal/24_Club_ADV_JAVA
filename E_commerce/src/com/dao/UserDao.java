package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.UserBean;
import com.util.DBConnection;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class UserDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	public boolean registerUser(UserBean user) throws SQLException {
		String query = "INSERT INTO users (email, username, password) VALUES (?, ?, ?)";
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getUsername());
			
			String hashedPassword = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
			
			pstmt.setString(3, hashedPassword);
			
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
				BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), storedHash);

				if(result.verified) {
					user = new UserBean();
					user.setUser_id(rs.getInt("user_id"));
					user.setUsername(rs.getString("username"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}