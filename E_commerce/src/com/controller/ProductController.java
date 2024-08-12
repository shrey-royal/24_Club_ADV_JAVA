package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.bean.ProductBean;
import com.dao.ProductDao;

@MultipartConfig
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao productDao = new ProductDao();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		try {
			if ("list".equals(action)) {
				List<ProductBean> products = productDao.getAllProducts();
				req.setAttribute("products", products);
				req.getRequestDispatcher("/views/listAllProducts.jsp").forward(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("/views/error.jsp");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		try {
			if("add".equals(action)) {
				ProductBean product = new ProductBean();
				product.setProductName(req.getParameter("product_name"));
				product.setProductDescription(req.getParameter("product_description"));
				product.setProductPrice(Double.parseDouble(req.getParameter("product_price")));
				
				Part imagePart = req.getPart("image");
				if(imagePart != null && imagePart.getSize() > 0) {
					
					String imageName = imagePart.getSubmittedFileName();
					InputStream inputStream = imagePart.getInputStream();
					byte[] imageData = IOUtils.toByteArray(inputStream);
					
					product.setImageData(imageData);
					product.setImageName(imageName);
				}
				productDao.addProduct(product);
				res.sendRedirect("products?action=list");
				
			} else {
				res.sendRedirect("error.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("/views/error.jsp");
		}
	}

}
