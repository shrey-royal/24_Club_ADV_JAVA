package adv;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class CartAttributeListener implements HttpSessionAttributeListener {

    public void attributeAdded(HttpSessionBindingEvent event)  { 
         if("cart".equals(event.getName())) {
        	 System.out.println("Cart attribute added: " + event.getValue());
         }
    }

    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	if("cart".equals(event.getName())) {
       	 System.out.println("Cart attribute removed: " + event.getValue());
        }
    }

    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	if("cart".equals(event.getName())) {
       	 System.out.println("Cart attribute replaced: " + event.getValue());
        }
    }
	
}
