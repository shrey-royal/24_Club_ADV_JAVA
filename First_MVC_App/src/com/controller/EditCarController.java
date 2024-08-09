package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CarBean;
import com.dao.CarDao;

public class EditCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		CarDao carDao = new CarDao();
		CarBean carBean = carDao.getCarById(id);
		
		req.setAttribute("carBean", carBean);
		
//		System.out.println(carBean.getId() + " / " + carBean.getMake() + " / " + carBean.getModel() + " / " + carBean.getYear() + " / " + carBean.getPrice());
		
		req.getRequestDispatcher("views/UpdateCar.jsp").forward(req, res);
	}
}
