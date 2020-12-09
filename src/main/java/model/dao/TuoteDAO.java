package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Tuote;

public class TuoteDAO extends DAO{

	public ArrayList<Tuote> findAll() {	
		Connection connection = null;  // tietokantayhteys
		PreparedStatement statement = null;  // sql-lause
		ResultSet resultset = null;   // select-lauseen tulostaulu
		ArrayList<Tuote> tuotelista = new ArrayList<Tuote>();
		Tuote tuote = null; 
		try {
			// Luodaan yhteys
			connection = getDBConnection();
			// Luodaan komento: haetaan kaikki rivit pizza-taulusta
			String sqlSelect = 
					"SELECT id, nimi, kuvaus, hinta FROM tuote;";
			// Valmistellaan komento:
			statement = connection.prepareStatement(sqlSelect);
			// Lähetetään select-komento suoritettavaksi tietokantapalvelimelle:
			resultset = statement.executeQuery();
			// Käydään tulostaulun rivit läpi ja luetaan readTuote()-metodilla:
			while (resultset.next()) {
				tuote = readTuote(resultset);
				// lisätään pizza listaan
				tuotelista.add(tuote);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeDBConnection(resultset, statement, connection); // Suljetaan
		}
	
		return tuotelista;
	}
	

	private Tuote readTuote(ResultSet resultset) {	
		try {
			// Haetaan yhden pizzan tiedot kyselyn tulostaulun (ResultSet-tyyppinen resultset-olion) aktiiviselta tietoriviltä
			int id = resultset.getInt("id");
			String nimi = resultset.getString("nimi");
			String kuvaus = resultset.getString("kuvaus");
			double hinta = resultset.getDouble("hinta");
		
		// Luodaan ja palautetaan uusi pizza
			return new Tuote(id, nimi, kuvaus, hinta);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean addTuote(Tuote tuote)  {
		Connection connection = null;
		PreparedStatement stmtInsert = null;
		boolean updateSuccessed = false; 
	

		try {
			// Luodaan tietokantayhteys
			connection = getDBConnection();
			// Luodaan komento: luodaan uusi asiakas tietokannan tauluun
			String sqlInsert = 
			"INSERT INTO tuote (nimi, kuvaus, hinta) VALUES (?, ?, ?);";
			// Valmistellaan komento:
			stmtInsert = connection.prepareStatement(sqlInsert);
			// Asetetaan parametrisoidun komennon parametrit yksi kerrallaan 
	        // customer-taulussa id-sarake auto_increment-tyyppinen
			stmtInsert.setString(1, tuote.getNimi());
			stmtInsert.setString(2, tuote.getKuvaus());
			stmtInsert.setDouble(3, tuote.getHinta());
			//Lähetetään INSERT-komento suoritettavaksi tietokantapalvelimelle
			int rowAffected = stmtInsert.executeUpdate();
			if (rowAffected == 1) updateSuccessed = true;
			
		} catch (SQLException e) {
			e.printStackTrace(); // consoleen näkyviin Exception-tilanteen tarkemmat tiedot vianjäljitystä varten
			throw new RuntimeException(e);
		} finally {
			closeDBConnection(stmtInsert, connection); // Suljetaan statement ja yhteys
		}
		return updateSuccessed;
	}
			
	public boolean removeTuote(int tuoteId) {
		Connection connection = null;
		PreparedStatement stmtDelete = null;
		boolean updateSuccessed = false;

		try {
			// Luodaan tietokantayhteys
			connection = getDBConnection();
			//Poistetaan henkilo tietokantasta:
			String sql = "DELETE FROM tuote WHERE id = ?";
			stmtDelete = connection.prepareStatement(sql);
			stmtDelete.setInt(1, tuoteId);
			//Lähetetään DELETE-komento suoritettavaksi tietokantapalvelimelle
			int rowAffected = stmtDelete.executeUpdate();
			if (rowAffected == 1) updateSuccessed = true;
			
		} catch (SQLException e) {
			e.printStackTrace(); // consoleen näkyviin Exception-tilanteen tarkemmat tiedot vianjäljitystä varten
			throw new RuntimeException(e);
		} finally {
			closeDBConnection(stmtDelete, connection); // Suljetaan statement ja yhteys
		}
		return updateSuccessed;
	}


	public Tuote findById(int id) throws SQLException {
		
		Connection connection = null;
		PreparedStatement stmtFind = null;
		
		connection = getDBConnection();
		
       	Tuote tuote = null;
        String sql = "SELECT * FROM tuote WHERE id = ?";
         
        stmtFind = connection.prepareStatement(sql);
        stmtFind.setInt(1, id);
         
        ResultSet resultSet = stmtFind.executeQuery();
         
        if (resultSet.next()) {
            String nimi = resultSet.getString("nimi");
            String kuvaus = resultSet.getString("kuvaus");
            double hinta = resultSet.getDouble("hinta");
             
            tuote = new Tuote(id, nimi, kuvaus, hinta);
        } else {
        	tuote = null;
        }
        resultSet.close();
        stmtFind.close();
        connection.close();
        return tuote;
		}

	
	public boolean update(Tuote tuote) throws SQLException {
		
		PreparedStatement stmtUpdate = null;
		Connection connection = null;
		boolean rowUpdated;
		try {
			connection = getDBConnection();
		
	        String sql = "UPDATE tuote SET nimi = ?, kuvaus = ?, hinta = ? WHERE id = ?";
	        
	        stmtUpdate = connection.prepareStatement(sql);
	        stmtUpdate.setString(1, tuote.getNimi());
	        stmtUpdate.setString(2, tuote.getKuvaus());
	        stmtUpdate.setDouble(3, tuote.getHinta());
	        stmtUpdate.setInt(4, tuote.getId());
	         
	        rowUpdated = stmtUpdate.executeUpdate() > 0;
	        stmtUpdate.close();
	        connection.close();
		} finally {
			connection.close(); // Suljetaan
		}
        return rowUpdated;     
    }
	
}
