

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

/**
 * Servlet implementation class ImprimeCupon
 */
public class ImprimeCupon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImprimeCupon() {
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
		
		ServletOutputStream outputStream = response.getOutputStream();
		
		URL urlImgRemera = getServletContext()
				.getResource("/WEB-INF/imagenes/cupon3.jpg");
		String mensaje = request.getParameter("mensaje");
		String codigo = Integer.toString(ThreadLocalRandom.
				current().nextInt(1000000,9999999)) ;
		
		
		BufferedImage buff_img = ImageIO.read(urlImgRemera);
		Graphics2D graphics = buff_img.createGraphics();
		graphics.setFont(new Font("Verdana", Font.BOLD, 40));
		graphics.setColor(Color.WHITE);
		graphics.drawString(mensaje, 380, 700);
		graphics.drawString(codigo, 1120, 860);
		
		ImageIO.write(buff_img, "jpg", outputStream);
		outputStream.close();
	}

}
