package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DataStore;
import bean.Event;

@WebServlet("/eventList")
public class EventListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<html><body><h1>Event List</h1>");
		out.println("<ul>");
		
		for (Event event : DataStore.getEvents()) {
			out.println("<li>" + event.getName() + " (" + event.getDate() + ") - " + event.getDescription() +
					"<form action='registerEvent' method='post'>" + 
					"<input type='hidden' name='eventId' value='"+event.getId()+"'/>" + 
					"<input type='text' name='userName' placeholder='Your Name' required />" +
					"<input type='submit' value='Register' />" +
					"</form></li>");
		}
		out.println("</ul>");
		out.println("<a href='Event_Registration.html'>Create Event</a>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
