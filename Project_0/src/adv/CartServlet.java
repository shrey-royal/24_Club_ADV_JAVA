package adv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<String> cart = (List<String>) session.getAttribute("cart");
		
		if(cart == null) {
			cart = new ArrayList<String>();
			session.setAttribute("cart", cart);
		}
		
		String action = req.getParameter("action");
		String item = req.getParameter("item");
		
		if("add".equals(action) && item != null) {
			cart.add(item);
		} else if("remove".equals(action) && item != null) {
			cart.remove(item);
		}
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.print("<html><body>");
		out.print("<h1>Shopping Cart</h1>");
		out.print("<ul>");
		for(String cartItem : cart) {
			out.print("<li>" + cartItem + "</li>");
		}
		out.print("</ul>");
		
		out.print("<a href='?action=add&item=apple'>Add Apple</a><br>");
		out.print("<a href='?action=remove&item=apple'>Remove Apple</a><br>");
		out.print("<a href='?action=add&item=banana'>Add Banana</a><br>");
		out.print("<a href='?action=remove&item=banana'>Remove Banana</a><br>");
		out.print("</body></html>");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
