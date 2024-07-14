package basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.print("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>Login</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<h1>User Login</h1>\r\n" + 
				"	\r\n" + 
				"	<form action=\"/Project_0/welcome\" method=\"post\">\r\n" + 
				"		<label for=\"username\">username: </label>\r\n" + 
				"		<input type=\"text\" name=\"username\" value="+req.getAttribute("u")+">\r\n" + 
				"		<br><br>\r\n" + 
				"		\r\n" + 
				"		<label for=\"password\">password: </label>\r\n" + 
				"		<input type=\"password\" name=\"password\" value="+req.getAttribute("p")+" >\r\n" + 
				"		<br><br>\r\n" + 
				"		\r\n" + 
				"		<button type=\"submit\">Login</button>\r\n" + 
				"	</form>\r\n" + 
				"</body>\r\n" + 
				"</html>");
		
		System.out.println("logged in");
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
