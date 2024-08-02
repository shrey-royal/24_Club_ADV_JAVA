package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DataStore;
import bean.Event;

@WebServlet("/createEvent")
public class EventCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String date = req.getParameter("date");
		String description = req.getParameter("description");
		
		Event event = new Event(id, name, date, description);
		DataStore.getEvents().add(event);
		
		res.setContentType("text/html");
		res.getWriter().println("<html><body><h1>Event Created Successfully!</h1><a href='eventList'>Back to Event List</a></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
