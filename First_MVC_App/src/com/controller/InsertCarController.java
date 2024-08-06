package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CarBean;
import com.dao.CarDao;


public class InsertCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String make = req.getParameter("make");
		String model = req.getParameter("model");
		int year = Integer.parseInt(req.getParameter("year"));
		double price = Double.parseDouble(req.getParameter("price"));
		
		System.out.println(make + " / " + model + " / " + year + " / " + price);
		
		CarBean carBean = new CarBean();
		CarDao carDao = new CarDao();
		
		carBean.setMake(make);
		carBean.setModel(model);
		carBean.setYear(year);
		carBean.setPrice(price);
		
		carDao.insertCar(carBean);
		
//		req.getRequestDispatcher("listall").forward(null, res);
		res.sendRedirect("http://localhost:8080/First_MVC_App/listall");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
