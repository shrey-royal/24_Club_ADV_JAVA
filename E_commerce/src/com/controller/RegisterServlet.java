package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDao();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("views/Register.html").forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("email");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		
		UserBean userBean = new UserBean();
		userBean.setEmail(email);
		userBean.setUsername(username);
		userBean.setPassword(password);
		userBean.setRole(role);
		
		try {
			if(userDao.registerUser(userBean)) {
				System.out.println("User registered successfully!");
				res.sendRedirect("views/Login.jsp");
			} else {
				System.out.println("User registration failed!");
				res.sendRedirect("views/error.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("views/error.jsp");
		}
	}

}
