package basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet_0 extends GenericServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init();
		System.out.println("Init Called!");
		System.out.println("Name: " + config.getServletName());
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Service Called!");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.print("<h2>Welcome to Karachi</h2>");
		
		out.close();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Destroy Called!");
	}
}
