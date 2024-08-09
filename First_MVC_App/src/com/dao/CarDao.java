package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
			pstmt.close();
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
			rs.close();
			conn.close();
			return cars;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public CarBean getCarById(int id) {
		String getQuery = "SELECT * FROM Cars WHERE id = ?";
		CarBean car = null;
		try {
			conn = DBConnection.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(getQuery);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				car = new CarBean();
				
				car.setId(rs.getInt("id"));
				car.setMake(rs.getString("make"));
				car.setModel(rs.getString("model"));
				car.setYear(rs.getInt("year"));
				car.setPrice(rs.getDouble("price"));
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return car;
	}

	public void updateCar(CarBean carBean) {
		try {
			String updateQuery = "UPDATE Cars SET make=?, model=?, year=?, price=? WHERE id=?";
			conn = DBConnection.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, carBean.getMake());
			pstmt.setString(2, carBean.getModel());
			pstmt.setInt(3, carBean.getYear());
			pstmt.setDouble(4, carBean.getPrice());
			pstmt.setInt(5, carBean.getId());
			
			if(pstmt.executeUpdate() == 1) {
				System.out.println("Car updated successfully!");
			} else {
				System.out.println("Failed to update car!");
			}
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCarById(int id) {
		try {
			String deleteQuery = "DELETE from Cars WHERE id=?";
			conn = DBConnection.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
			pstmt.setInt(1, id);
			
			if(pstmt.executeUpdate() > 0) {
				System.out.println("Car deleted successfully!");
			} else {
				System.out.println("Failed to delete car!");
			}
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
