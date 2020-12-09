package launch;

import model.dao.TuoteDAO;
import model.dao.VaateDAO;

public class TuoteDAOKokeiluOhjelma {
	
	public static void main (String[] args) {
		
		TuoteDAO tuotedao = new TuoteDAO();
		System.out.println(tuotedao.findAll());
		
		VaateDAO vaatedao = new VaateDAO();
		System.out.println(vaatedao.findAll());
		
		
	}
}
