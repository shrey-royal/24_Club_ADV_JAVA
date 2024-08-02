package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DataStore;
import bean.Registration;

@WebServlet("/registrationList")
public class RegistrationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String eventId = req.getParameter("eventId");
		List<Registration> eventResgistrations = new ArrayList<Registration>();
		
		for (Registration registration : DataStore.getRegistrations()) {
			if(registration.getEventId().equals(eventId)) {
				eventResgistrations.add(registration);
			}
		}
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.print("<html><body><h1>Registration List</h1>");
		out.print("<ul>");
		for (Registration registration : eventResgistrations) {
			out.print("<li>" + registration.getUserName() + "</li>");
		}
		out.print("</ul>");
		out.print("<a href='eventList'>Back to Event List</a>");
		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
