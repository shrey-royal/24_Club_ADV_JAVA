package adv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CkProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		req.getRequestDispatcher("adv_serv/link.html").include(req, res);
		
		Cookie ck[] = req.getCookies();
		if(ck != null) {
			String name = ck[0].getValue();
			if(!name.equals("") || name != null) {
				out.print("<b>Welcome to Profile</b>");
				out.print("<br>Welcome, " + name);
			}
		} else {
			out.print("Please login first<br>");
			req.getRequestDispatcher("adv_serv/ck_login.html").include(req, res);
		}
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
