package controler;

import java.io.IOException;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Collection;
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
import service.Service;

@WebServlet("/adaugaInCos")
public class ServletCos extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("ceasuri", Service.dao.showCeas());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cos.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Luam de pe request id-ul produsului care a fost adaugat in cos
		String idString = (String) request.getParameter("id");

		HttpSession sesiune = request.getSession();

		sesiune.setMaxInactiveInterval(60 * 60 * 2);

		// Luam atributul cos de pe sesiune.
		List<Ceas> cos = (List<Ceas>) sesiune.getAttribute("cos");

		if (cos == null) {
			// cream cosul.
			cos = new ArrayList<Ceas>();
			// il punem ca atribut pe sesiune
			sesiune.setAttribute("cos", cos);
		}

		// adaugam in cos articolul
		cos.add(Dao.getCeas(idString));

		// adaugam pe request, inca o data, un atribut
		// cu toate articolele pe care le avem in baza de date
		// pentru ca sa fie afisate.
		request.setAttribute("ceasuri", Dao.afiseazaCeasuri());

		// facem forward tot la pagina afsieaza.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home.jsp");
		dispatcher.forward(request, response);
		
	}

	
}
