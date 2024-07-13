package basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	res.setContentType("text/html");
		ServletConfig config = getServletConfig();
		PrintWriter out = null;
		
		//System.out.println(config.getInitParameter("username"));
		//System.out.println(config.getInitParameter("password"));

		if(config.getInitParameter("username").equals(req.getParameter("username")) && config.getInitParameter("password").equals(req.getParameter("password"))) {
			req.getRequestDispatcher("welcome").forward(req, res);
		} else {
			out = res.getWriter();
			out.print("<strong style=\"color: red;\">Invalid username or password!</strong>");
			req.getRequestDispatcher("/basics/login.html").include(req, res);
		}
		out.close();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
