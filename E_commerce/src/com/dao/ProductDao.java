package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.ProductBean;
import com.util.DBConnection;

public class ProductDao {
	public void addProduct(ProductBean product) {
		String query = "INSERT INTO products (product_name, product_description, product_price, image_data, image_name) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductDescription());
			ps.setDouble(3, product.getProductPrice());
			ps.setBytes(4, product.getImageData());
			ps.setString(5, product.getImageName());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public List<ProductBean> getAllProducts() {
		List<ProductBean> products = new ArrayList<>();
		String query = "SELECT * FROM products";
		try (Connection conn = DBConnection.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			while(rs.next()) {
				ProductBean product = new ProductBean();
				
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductDescription(rs.getString("product_description"));
				product.setProductPrice(rs.getDouble("product_price"));
				product.setImageData(rs.getBytes("image_data"));
				product.setImageName(rs.getString("image_name"));
				products.add(product);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
}
