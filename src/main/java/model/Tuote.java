package model;

public class Tuote {
	
	public static double withMathRound(double value, int places) {
	    double scale = Math.pow(10, places);
	    return Math.round(value * scale) / scale;
	}
	
	private int id;
	private String nimi;
	private String kuvaus;
	private double hinta;
	
	public Tuote(int id, String nimi, String kuvaus, double hinta) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.kuvaus = kuvaus;
		this.hinta = hinta;
	}

	public Tuote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tuote(String nimi, String kuvaus, double hinta) {
		this.id = 0;
		this.nimi = nimi;
		this.kuvaus = kuvaus;
		this.hinta = hinta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	@Override
	public String toString() {
		return "Tuote " + getId() + ": " + getNimi() + " " + getKuvaus() + " " + getHinta();
	}
	
	
}
