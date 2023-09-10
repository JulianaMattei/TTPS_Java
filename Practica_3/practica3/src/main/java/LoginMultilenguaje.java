

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Servlet implementation class LoginMultilenguaje
 */
public class LoginMultilenguaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMultilenguaje() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//tiene que analizar el lenguaje y crear el form con el lenguaje ese
		
		String lang = request.getHeader("idiomaCliente");
		ResourceBundle bundle;
		if (lang == "es") {
			Locale locale = new Locale("es", "ES");
			bundle = ResourceBundle.getBundle("textos_es", locale);
		} else {
			Locale locale = new Locale("en", "EN");
			bundle = ResourceBundle.getBundle("textos_en", locale);
		}
		String titulo = bundle.getString("titulo");
		String usuario = bundle.getString("labelusuario");
		String contrasena = bundle.getString("labelpassword");

		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h2> " + titulo + " </h2>");
		out.println("<form action=\"Login\" method=\"POST\">");
		out.println(usuario + ": <input type=\"text\" name=\"nombre\"><br>");
		out.println(contrasena + ": <input type=\"password\" name=\"clave\"><br>");
		out.println("<input type=\"submit\" name=\"b1\" value=\":)\"><br>");
		out.println("</form>");
		out.println("</body></html>");
		out.close();

	}

}
