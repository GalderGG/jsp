package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class receiver
 */
@WebServlet("/receiver")
public class receiver extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public receiver() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");

		System.out.println(nombre + " " + apellido);

		request.setAttribute("nombre", nombre);
		request.setAttribute("apellido", apellido);

		request.getRequestDispatcher("datosDeFrom.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String adminUser = "Admin";
		String adminPass = "Admin";
		
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		request.setAttribute("user", user);
		request.setAttribute("password", password);

		if (user.equals(adminUser) && password.equals(adminPass)) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			request.setAttribute("error", "usuario o contase�a incorrectas");
			request.getRequestDispatcher("postform.jsp").forward(request, response);
		}
	}
}
