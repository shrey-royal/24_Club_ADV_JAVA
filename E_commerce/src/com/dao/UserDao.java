package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.UserBean;
import com.util.DBConnection;

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
			pstmt.setString(3, user.getPassword());
			
			return (pstmt.executeUpdate() == 1) ? true: false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}