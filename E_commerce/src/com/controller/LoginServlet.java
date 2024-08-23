package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("views/Login.jsp").forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		try {
			UserBean userBean = userDao.validateUser(username, password);
			if(userBean != null) {
				HttpSession session = req.getSession();
				session.setAttribute("userBean", userBean);
				if("admin".equals(userBean.getRole())) {
					res.sendRedirect("products?action=list");
				} else {
					res.sendRedirect("products?action=allproducts");
				}
			} else {
				req.setAttribute("errorMessage", "Invalid username or password");
				req.getRequestDispatcher("views/Login.jsp").forward(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("views/error.jsp");
		}
	}

}
