package adv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class EL0 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String n = req.getParameter("name");
		out.print("Welcome, " + n);
		
		HttpSession session = req.getSession();
		session.setAttribute("uname", n);
		
		ServletContext context = req.getServletContext();
		int t = (Integer)context.getAttribute("totalusers");
		int c = (Integer)context.getAttribute("currentusers");
		out.print("<br> Total Users: " + t);
		out.print("<br> Current Users: " + c);
		
		out.print("<br><a href='/Project_0/EL1'>logout</a>");
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
