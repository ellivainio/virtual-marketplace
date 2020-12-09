package control;

import model.dao.VaateDAO;
import model.Vaate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/muokkaa-vaatetta")

public class MuokkaaVaatettaServlet extends HttpServlet {
	
	public void init() {
		VaateDAO vaatedao = new VaateDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("vaateid"));
			VaateDAO vaatedao = new VaateDAO();
			Vaate muokattavaVaate = vaatedao.findById(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vaatteenmuokkauslomake.jsp");
			request.setAttribute("vaate", muokattavaVaate);
			dispatcher.forward(request, response);

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
}