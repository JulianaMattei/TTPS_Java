

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FiltroLogAccesos
 */
public class FiltroLogAccesos extends HttpFilter implements Filter {
       
	private FilterConfig config;
	
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FiltroLogAccesos() {
        super();
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		config = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		String ipCliente = req.getRemoteAddr();
		String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String reqLine = req.getMethod() + " " + req.getRequestURI() +
				" " + req.getProtocol();
		String userAgent = req.getHeader("User-Agent");
		
		
		String logEntry = String.format("IP: %s - [%s] , Request Line: %s, User-Agent: %s"
				, ipCliente, dateTime, reqLine, userAgent);
		
		System.out.println(logEntry);

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

}
