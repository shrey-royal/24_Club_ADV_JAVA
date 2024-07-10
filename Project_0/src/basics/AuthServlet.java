package basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth1")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		if(req.getParameter("username").equals("user0") && req.getParameter("password").equals("user0")) {
			System.out.println("Credentials are Correct");
//			res.sendRedirect("https://www.youtube.com");
			req.getRequestDispatcher("welcome").forward(req, res);
		}
		else {
			req.getRequestDispatcher("/basics/login.html").include(req, res);
			out.print("<strong style=\"color: red;\">Credentials are Incorrect</strong>");
		}
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
