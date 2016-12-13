package controler;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.Service;



public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
		request.setAttribute("mesaj", "");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		String parola = request.getParameter("parola");
		
		HashMap<String, String> mapUseri = Service.dao.getUseri();

		//System.out.println("Inainte de verificare " + user + parola + " " + mapUseri.get(user));

		if (mapUseri.get(email) != null) {

			//System.out.println("Verificare existenta user");

			if (mapUseri.get(email).equals(parola)) {

				//System.out.println("Verific parola corecta");

				HttpSession sesiune = request.getSession();

				User utilizator = new User(email, parola);

				sesiune.setAttribute("user", utilizator);

				response.sendRedirect("upload");

			} else {
				System.out.println("Sunt in verificare parola incorecta");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");

				request.setAttribute("mesaj", "Ati introdus parola gresita !");

				dispatcher.forward(request, response);
			}

		} else {
			
			response.sendRedirect("home");
		}
	}

}
