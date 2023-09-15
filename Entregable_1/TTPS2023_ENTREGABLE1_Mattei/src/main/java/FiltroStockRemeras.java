

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FiltroStockRemeras
 */
public class FiltroStockRemeras implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FiltroStockRemeras() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletResponse res = (HttpServletResponse) response;
		
		ServletContext sc = request.getServletContext();
		
		int contadorRemeras = (Integer) sc.getAttribute("cantidad_remeras");
		
		if (contadorRemeras > 0) {
			contadorRemeras--;
			sc.setAttribute("cantidad_remeras", contadorRemeras);
			chain.doFilter(request, response);
		}	
		else
			res.sendRedirect("sinStock.html");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
