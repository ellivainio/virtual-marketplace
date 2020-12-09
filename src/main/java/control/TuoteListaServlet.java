package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Tuote;
import model.Vaate;
import model.dao.TuoteDAO;
import model.dao.VaateDAO;

@WebServlet("/omat-tuotteet")

public class TuoteListaServlet extends HttpServlet {
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TuoteDAO tuotedao = new TuoteDAO();
		ArrayList<Tuote> tuotelista = tuotedao.findAll();
		
		VaateDAO vaatedao = new VaateDAO();
		ArrayList<Vaate> vaatelista = vaatedao.findAll();
		
		request.setAttribute("tuotelista", tuotelista);
		request.setAttribute("vaatelista", vaatelista);
		
		request.getRequestDispatcher("/WEB-INF/tuotelista.jsp").forward(request, response);											
	}
}
