package adv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		req.getRequestDispatcher("adv_serv/link.html").include(req, res);
		
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
	
		if(pass.equals("superuser")) {
			out.print("You are successfully logged in!");
			out.print("<br>Welcome, " + name);
			
			HttpSession session = req.getSession();
			session.setAttribute("name", name);
			session.setAttribute("pass", pass);
		} else {
			out.print("Sorry, username or password error!");
			req.getRequestDispatcher("adv_serv/sesslogin.html").include(req, res);
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
