package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DataStore;
import bean.Registration;

@WebServlet("/registerEvent")
public class EventRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String eventId = req.getParameter("eventId");
		String userName = req.getParameter("userName");
		
		Registration registration = new Registration(eventId, userName);
		DataStore.getRegistrations().add(registration);
		
		res.setContentType("text/html");
		res.getWriter().println("<html><body><h1>Registration Successfull!</h1><a href='eventList'>Back to Event List</a></body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
}
