package adv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CkLoginServlet extends HttpServlet {
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
			
			Cookie ck = new Cookie("name", name);
			res.addCookie(ck);			
		} else {
			out.print("Sorry, username or password error!");
			req.getRequestDispatcher("adv_serv/ck_login.html").include(req, res);
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
