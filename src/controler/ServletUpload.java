package controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import model.Ceas;
import service.Service;

/**
 * Servlet implementation class ServletUpload
 */
public class ServletUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Ceas>ceasuri= Service.dao.afiseazaCeasuri();
		request.setAttribute("ceasuri", ceasuri);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/upload.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String marca = request.getParameter("marca");
			String model = request.getParameter("model");
			String gen = request.getParameter("gen");
			String calibru = request.getParameter("calibru");
			String material = request.getParameter("material");
			String curea = request.getParameter("curea");
			String mecanism = request.getParameter("mecanism");
			String geam = request.getParameter("geam");
			String pretString = request.getParameter("pret");
			String stocStr = request.getParameter("stoc");
			String detalii = request.getParameter("detalii");
			String img = request.getParameter("img");
			
			double pret=0;
			int stoc=0;
			try{
			pret= Double.parseDouble(pretString);
			stoc= Integer.parseInt(stocStr);
			}catch(NumberFormatException e){
				request.setAttribute("mesaj", "Pretul sau stocul nu au formatul valid");
				RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/upload.jsp");
				dispatcher.forward(request, response);
			}
		
				Ceas ceasuri = new Ceas(marca, model, gen, calibru, material, curea, mecanism, geam, pret, stoc, detalii, img);
				
				boolean bool = Service.dao.insereazaCeas(ceasuri);

				if (bool) {
										
					request.setAttribute("mesaj_ok", "Ceasul a fost adaugat cu succes");
				} else {
					request.setAttribute("mesaj_not_ok", "Ceasul nu a putut fi adaugat");
				}
	
			RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/upload.jsp");
			dispatcher.forward(request, response);
}}
