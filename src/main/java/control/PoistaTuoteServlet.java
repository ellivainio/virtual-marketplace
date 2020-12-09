package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.TuoteDAO;

@WebServlet("/poista-tuote")
public class PoistaTuoteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			// Sijoitetaan muuttujaan pyynnön parametrina tullut poistettavan asiakkaan
			// id-arvo
			String idStr = request.getParameter("tuoteid");
			int tuoteId = Integer.parseInt(idStr);
			// Luodaan asiakasdao
			TuoteDAO tuotedao = new TuoteDAO();
			// Poistetaan asiakkaan tiedot tietokannasta
			boolean poistoOnnistui = tuotedao.removeTuote(tuoteId);
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
			request.setAttribute("viesti", "Sovelluksessa tapahtui virhe.");
			// servlet kutsuu jsp:tä
			request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
		}
		
	}

}