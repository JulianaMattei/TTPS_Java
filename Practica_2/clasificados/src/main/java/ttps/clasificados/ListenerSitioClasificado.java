package ttps.clasificados;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class ListenerSitioClasificado
 *
 */
public class ListenerSitioClasificado implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ListenerSitioClasificado() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        String nombreSitio = sce.getServletContext().getInitParameter("nombreSitio");
        String email = sce.getServletContext().getInitParameter("emailSitio");
        String telef = sce.getServletContext().getInitParameter("telefonoContacto");
        
        ServletContext contexto = sce.getServletContext();
        contexto.setAttribute("nombreSitio", nombreSitio);
        contexto.setAttribute("emailSitio", email);
        contexto.setAttribute("telefonoContacto", telef);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
