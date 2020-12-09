package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vaate;
import model.dao.VaateDAO;

@WebServlet("/lisaa-vaate")
public class LisaaVaateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/vaatelomake.jsp").forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String nimi = request.getParameter("nimi");
			String kuvaus = request.getParameter("kuvaus");
			String hintaStr = request.getParameter("hinta");
			double hinta = Double.parseDouble(hintaStr);
			String koko = request.getParameter("koko");
			String merkki = request.getParameter("merkki");
			
			Vaate uusiVaate = new Vaate(nimi, kuvaus, hinta, koko, merkki);
			System.out.println(uusiVaate);
			
			VaateDAO vaatedao = new VaateDAO();
			// tallennetaan tiedot tietokantaan 
			boolean lisaysOnnistui = vaatedao.addVaate(uusiVaate);
			if (lisaysOnnistui)
				// uudelleenohjaus /listaa-asiakkaat endpointtiin  .jps-käsittelyn sijaan 
				response.sendRedirect("/omat-tuotteet"); 
			else {

				request.setAttribute("viesti", "Tuotteen lisäyksessä tietokantaan tapahtui virhe.");
				// servlet kutsuu jsp:tä
				request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
			}

		} catch (NumberFormatException e) {
			
			e.printStackTrace();  // tulostetaan Consoleen virhetilanteessa metodikutsupinoa, josta näkee rivinumeron, jossa Exception tapahtuu

			request.setAttribute("viesti", "Lomakkeelle syötetyt tiedot eivät olleet kelvolliset.");
			// servlet kutsuu jsp:tä
			request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
		}
	}
}