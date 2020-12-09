package control;

import model.dao.TuoteDAO;
import model.Tuote;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/muokkaa-tuotetta")

public class MuokkaaTuotettaServlet extends HttpServlet {
	
	public void init() {
		TuoteDAO tuotedao = new TuoteDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("tuoteid"));
			TuoteDAO tuotedao = new TuoteDAO();
			Tuote muokattavaTuote = tuotedao.findById(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/muokkauslomake.jsp");
			request.setAttribute("tuote", muokattavaTuote);
			dispatcher.forward(request, response);

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
}