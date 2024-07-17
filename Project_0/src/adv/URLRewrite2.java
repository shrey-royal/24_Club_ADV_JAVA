package adv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/urlrewrite2")
public class URLRewrite2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	res.setContentType("text/html");
    	PrintWriter out = res.getWriter();
    	
    	String n = req.getParameter("naam");
    	out.print("Welcome to 2, " + n);
    	
    	out.close();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}