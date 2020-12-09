package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Tuote;
import model.dao.TuoteDAO;

@WebServlet("/paivita-tuote")
public class TallennaMuokattuTuoteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/muokkauslomake.jsp").forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("id").trim());
			String nimi = request.getParameter("nimi");
			String kuvaus = request.getParameter("kuvaus");
			Double hinta = Double.parseDouble(request.getParameter("hinta"));
	
			Tuote tuote = new Tuote(id, nimi, kuvaus, hinta);
			TuoteDAO tuotedao = new TuoteDAO();
			tuotedao.update(tuote);
			response.sendRedirect("/omat-tuotteet");
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
}