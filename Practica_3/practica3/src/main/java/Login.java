

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	//del tp anterior
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public void agregarUsuarios() {
		usuarios.add(new Usuario("Pepe","abc1"));
		usuarios.add(new Usuario("Juan","abc2"));
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        agregarUsuarios();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String clave = request.getParameter("clave");
		
		Usuario user = usuarios.stream().filter(u -> u.validarUsuario(nombre, clave))
				.findFirst().orElse(null);
		
		if (user == null) {
			response.sendRedirect("error.html");
		}
		else {
			response.sendRedirect("bienvenido.html");
		}
	}

}
