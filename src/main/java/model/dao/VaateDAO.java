package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Vaate;

public class VaateDAO extends DAO{

	public ArrayList<Vaate> findAll() {	
		Connection connection = null;  // tietokantayhteys
		PreparedStatement statement = null;  // sql-lause
		ResultSet resultset = null;   // select-lauseen tulostaulu
		ArrayList<Vaate> vaatelista = new ArrayList<Vaate>();  // tyhjä pizzalista
		Vaate vaate = null; 
		try {
			// Luodaan yhteys
			connection = getDBConnection();
			// Luodaan komento: haetaan kaikki rivit pizza-taulusta
			String sqlSelect = 
					"SELECT id, nimi, kuvaus, hinta, koko, merkki FROM vaate;";
			// Valmistellaan komento:
			statement = connection.prepareStatement(sqlSelect);
			// Lähetetään select-komento suoritettavaksi tietokantapalvelimelle:
			resultset = statement.executeQuery();
			// Käydään tulostaulun rivit läpi ja luetaan readPizza()-metodilla:
			while (resultset.next()) {
				vaate = readVaate(resultset);
				// lisätään pizza listaan
				vaatelista.add(vaate);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeDBConnection(resultset, statement, connection); // Suljetaan
		}
	
		return vaatelista;
	}
	

	private Vaate readVaate(ResultSet resultset) {	
		try {
			// Haetaan yhden pizzan tiedot kyselyn tulostaulun (ResultSet-tyyppinen resultset-olion) aktiiviselta tietoriviltä
			int id = resultset.getInt("id");
			String nimi = resultset.getString("nimi");
			String kuvaus = resultset.getString("kuvaus");
			double hinta = resultset.getDouble("hinta");
			String koko = resultset.getString("koko");
			String merkki = resultset.getString("merkki");
		
		// Luodaan ja palautetaan uusi pizza
			return new Vaate(id, nimi, kuvaus, hinta, koko, merkki);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public boolean addVaate(Vaate vaate)  {
		Connection connection = null;
		PreparedStatement stmtInsert = null;
		boolean updateSuccessed = false; 
	

		try {
			// Luodaan tietokantayhteys
			connection = getDBConnection();
			// Luodaan komento: luodaan uusi asiakas tietokannan tauluun
			String sqlInsert = 
			"INSERT INTO vaate (nimi, kuvaus, hinta, koko, merkki) VALUES (?, ?, ?, ?, ?)";
			// Valmistellaan komento:
			stmtInsert = connection.prepareStatement(sqlInsert);
			// Asetetaan parametrisoidun komennon parametrit yksi kerrallaan 
	        // customer-taulussa id-sarake auto_increment-tyyppinen
			stmtInsert.setString(1, vaate.getNimi());
			stmtInsert.setString(2, vaate.getKuvaus());
			stmtInsert.setDouble(3, vaate.getHinta());
			stmtInsert.setString(4, vaate.getKoko());
			stmtInsert.setString(5, vaate.getMerkki());
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
			
	public boolean removeVaate(int vaateId) {
		Connection connection = null;
		PreparedStatement stmtDelete = null;
		boolean updateSuccessed = false;

		try {
			// Luodaan tietokantayhteys
			connection = getDBConnection();
			//Poistetaan henkilo tietokantasta:
			String sql = "DELETE FROM vaate WHERE id = ?";
			stmtDelete = connection.prepareStatement(sql);
			stmtDelete.setInt(1, vaateId);
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
	
	public Vaate findById(int id) throws SQLException {
			
			Connection connection = null;
			PreparedStatement stmtFind = null;
			
			connection = getDBConnection();
			
	       	Vaate vaate = null;
	        String sql = "SELECT * FROM vaate WHERE id = ?";
	         
	        stmtFind = connection.prepareStatement(sql);
	        stmtFind.setInt(1, id);
	         
	        ResultSet resultSet = stmtFind.executeQuery();
	         
	        if (resultSet.next()) {
	            String nimi = resultSet.getString("nimi");
	            String kuvaus = resultSet.getString("kuvaus");
	            double hinta = resultSet.getDouble("hinta");
	            String koko = resultSet.getString("koko");
	            String merkki = resultSet.getString("merkki");
	             
	            vaate = new Vaate(id, nimi, kuvaus, hinta, koko, merkki);
	        } else {
	        	vaate = null;
	        }
	        resultSet.close();
	        stmtFind.close();
	        connection.close();
	        return vaate;
			}
	
		
		public boolean update(Vaate vaate) throws SQLException {
			
			PreparedStatement stmtUpdate = null;
			Connection connection = null;
			boolean rowUpdated;
			try {
				connection = getDBConnection();
			
		        String sql = "UPDATE vaate SET nimi = ?, kuvaus = ?, hinta = ?, koko = ?, merkki = ? WHERE id = ?";
		        
		        stmtUpdate = connection.prepareStatement(sql);
		        stmtUpdate.setString(1, vaate.getNimi());
		        stmtUpdate.setString(2, vaate.getKuvaus());
		        stmtUpdate.setDouble(3, vaate.getHinta());
		        stmtUpdate.setString(4, vaate.getKoko());
		        stmtUpdate.setString(5, vaate.getMerkki());
		        stmtUpdate.setInt(6, vaate.getId());
		         
		        rowUpdated = stmtUpdate.executeUpdate() > 0;
		        stmtUpdate.close();
		        connection.close();
			} finally {
				connection.close(); // Suljetaan
			}
	        return rowUpdated;     
	    }
}

