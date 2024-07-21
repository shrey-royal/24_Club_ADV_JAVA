package adv;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se)  { 
         System.out.println("Session Created: " + se.getSession().getId());
    }

	public void sessionDestroyed(HttpSessionEvent se)  { 
        System.out.println("Session Destroyed: " + se.getSession().getId());
    }
	
}
