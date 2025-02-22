package basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		ServletContext context = getServletContext();
		
		out.print("<html><body>");
		out.print("Welcome, <strong style=\"color: limegreen;\">" + req.getParameter("username") + "</strong>");
		out.print("This page is built by , <strong style=\"color: magenta;\">" +  context.getInitParameter("superuser") + "</strong>");
		
		out.print("</body></html>");
		
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
