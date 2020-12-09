package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vaate;
import model.dao.VaateDAO;

@WebServlet("/paivita-vaate")
public class TallennaMuokattuVaateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vaatteenmuokkauslomake.jsp").forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("id").trim());
			String nimi = request.getParameter("nimi");
			String kuvaus = request.getParameter("kuvaus");
			Double hinta = Double.parseDouble(request.getParameter("hinta"));
			String koko = request.getParameter("koko");
			String merkki = request.getParameter("merkki");
	
			Vaate vaate = new Vaate(id, nimi, kuvaus, hinta, koko, merkki);
			VaateDAO vaatedao = new VaateDAO();
			vaatedao.update(vaate);
			response.sendRedirect("/omat-tuotteet");
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
}