package controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import model.Ceas;


@WebServlet("/golesteCos")
public class ServletGolesteCos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idString = (String) request.getParameter("id");

		HttpSession sesiune = request.getSession();

		sesiune.setMaxInactiveInterval(60 * 60 * 2);

		// Luam atributul cos de pe sesiune.
		List<Ceas> cos = (List<Ceas>) sesiune.getAttribute("cos");

//		if (cos == null) {
//			// cream cosul.
//			cos = new ArrayList<Ceas>();
//			// il punem ca atribut pe sesiune
//			sesiune.setAttribute("cos", cos);
//		}

		cos.clear();;
		// facem forward tot la pagina home.jsp
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home.jsp");
				dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
