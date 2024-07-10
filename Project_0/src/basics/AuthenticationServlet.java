package basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth")		//used to change the url of the servlet
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		RequestDispatcher rd = null;
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
	
		String u = "admin";
		String p = "Admin@123";
		
		out.print("<html><body>");
		if(u.equals(username) && p.equals(password)) {
			out.print("<strong style=\"color: green;\">Login Successful!</strong>");
			//direct way
			req.getRequestDispatcher("index.html").forward(req, res);
			
		} else {
			out.print("<strong style=\"color: red;\">Login Unsuccessful!</strong>");
			rd = req.getRequestDispatcher("/basics/login.html");
		}
		out.print("</body></html>");
		
		rd.forward(req, res);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
