package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.CarBean;
import com.util.DBConnection;

public class CarDao {
	private Connection conn = null;
	
	public void insertCar(CarBean car) {
		try {
			String insertQuery = "INSERT INTO Cars(id, make, model, year, price) VALUES(0, ?, ?, ?, ?)";
			conn = DBConnection.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);
			pstmt.setString(1, car.getMake());
			pstmt.setString(2, car.getModel());
			pstmt.setInt(3, car.getYear());
			pstmt.setDouble(4, car.getPrice());
			
			if(pstmt.executeUpdate() == 1) {
				System.out.println("New car added successfully!");
			} else {
				System.out.println("Failed to add a new car!");
			}
			conn.close();		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<CarBean> getAllCars() {
		ArrayList<CarBean> cars = new ArrayList<CarBean>();
		String listQuery = "SELECT * FROM Cars";
		
		try {
			conn = DBConnection.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(listQuery);
			
			while(rs.next()) {
				CarBean car = new CarBean();
				car.setId(rs.getInt("id"));
				car.setMake(rs.getString("make"));
				car.setModel(rs.getString("model"));
				car.setYear(rs.getInt("year"));
				car.setPrice(rs.getDouble("price"));
				cars.add(car);
			}
			conn.close();
			return cars;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
