package adv;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter implements javax.servlet.Filter {

    public void destroy() {
		System.out.println("Filter Destroyed!");
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		String n = req.getParameter("name");
		String p = req.getParameter("pass");
		
		if(n == "" || p == "") {
			System.out.println("Not a valid input!");
			System.out.println(n + " / " + p);
			req.setAttribute("name", "admin");
			req.setAttribute("pass", "Admin@123");			
		}
		
//		if(n == "" || p == "") {
//			req.getRequestDispatcher("adv_serv/filter.html").forward(req, res);
//		}
		
		chain.doFilter(req, res);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter Init");
	}

}
