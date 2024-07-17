package adv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/urlrewrite")
public class URLRewrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	res.setContentType("text/html");
    	PrintWriter out = res.getWriter();
    	
    	String n = req.getParameter("name");
    	out.print("Welcome, " + n);
    	
    	out.print("<a href='urlrewrite2?naam="+n+"'>visit</a>");
    	
    	out.close();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}