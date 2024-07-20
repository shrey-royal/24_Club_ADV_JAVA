package adv;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Lis1 implements HttpSessionListener {
	ServletContext context = null;
	static int total = 0, current = 0;
	
    public void sessionCreated(HttpSessionEvent se)  { 
    	total++;
    	current++;
    	
    	context = se.getSession().getServletContext();
    	context.setAttribute("totalusers", total);
    	context.setAttribute("currentusers", current);
    }

	public void sessionDestroyed(HttpSessionEvent se)  { 
         current--;
         context.setAttribute("currentusers", current);
    }
	
}
