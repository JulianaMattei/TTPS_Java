


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class Contador
 *
 */
public class Contador implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Contador() {
        // TODO Auto-generated constructor stub
    }


	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         int cantidad = Integer.parseInt(sce.getServletContext()
        		 .getInitParameter("cantidad_remeras"));
         
         ServletContext sc = sce.getServletContext();
         sc.setAttribute("cantidad_remeras", cantidad);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	
}
