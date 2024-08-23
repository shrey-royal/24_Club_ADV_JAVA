package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.CartItem;
import com.bean.ProductBean;
import com.dao.ProductDao;


public class CartItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao productDao = new ProductDao();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
		
		if(cart == null) {
			cart = new ArrayList<CartItem>();
			session.setAttribute("cart", cart);
		}
		
		req.setAttribute("cart", cart);
		req.getRequestDispatcher("views/Cart.jsp").forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
		
		if(cart == null) {
			cart = new ArrayList<CartItem>();
			session.setAttribute("cart", cart);
		}
		
		int productId = Integer.parseInt(req.getParameter("productId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		try {
			ProductBean productBean = productDao.getProductById(productId);
			boolean itemExists = false;
			
			for(CartItem item : cart) {
				if(item.getProductId() == productId) {
					item.setQuantity(item.getQuantity() + quantity);
					itemExists = true;
					break;
				}
			}
			
			if(!itemExists) {
				cart.add(new CartItem(productBean.getProductId(), productBean.getProductName(), quantity, productBean.getProductPrice()));
			}
			
			session.setAttribute("cart", cart);
			res.sendRedirect("cart");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect(req.getContextPath() + "views/error.jsp");
		}
	}

}
