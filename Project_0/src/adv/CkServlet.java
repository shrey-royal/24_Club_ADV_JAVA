package adv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ckserv")
public class CkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		Cookie ck = new Cookie("naam", req.getParameter("name"));
		ck.setVersion(1);
		ck.setMaxAge(60*60);
		
		res.addCookie(ck);	//adding cookie
		
		out.print("<form action=\"ckserv2\" method=\"post\">");
		out.print("<input type='submit' value='Buri Buri Zymon'>");
		out.print("</form>");
		
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
