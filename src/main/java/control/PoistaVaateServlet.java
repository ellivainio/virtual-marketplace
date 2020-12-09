package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.VaateDAO;

@WebServlet("/poista-vaate")
public class PoistaVaateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			// Sijoitetaan muuttujaan pyynnön parametrina tullut poistettavan asiakkaan
			// id-arvo
			String idStr = request.getParameter("vaateid");
			int vaateId = Integer.parseInt(idStr);
			// Luodaan asiakasdao
			VaateDAO vaatedao = new VaateDAO();
			// Poistetaan asiakkaan tiedot tietokannasta
			boolean poistoOnnistui = vaatedao.removeVaate(vaateId);
			if (poistoOnnistui) {
				// uudelleenohjataan pyyntö /listaa-asiakkaat-endpointiin
				response.sendRedirect("/poisto-lista");
			} else {
				request.setAttribute("viesti", "Tuotteen poistossa tapahtui virhe.");
				// servlet kutsuu jsp:tä
				request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();	
			request.setAttribute("viesti", "Sovelluksessa tapahtui virhe,");
			// servlet kutsuu jsp:tä
			request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
		}

		
	}

}