package model;

public class Vaate extends Tuote {
	
	private String koko;
	private String merkki;
	
	public Vaate(int id, String nimi, String kuvaus, double hinta, String koko, String merkki) {
		super(id, nimi, kuvaus, hinta);
		this.koko = koko;
		this.merkki = merkki;
	}
	
	public Vaate() {
		super();
		this.koko = "";
		this.merkki = "";
	}

	public Vaate(int id, String nimi, String kuvaus, double hinta) {
		super(id, nimi, kuvaus, hinta);
	}
	
	public Vaate(String nimi, String kuvaus, double hinta, String koko, String merkki) {
		super(nimi, kuvaus, hinta);
		this.koko = koko;
		this.merkki = merkki;
	}

	public String getKoko() {
		return koko;
	}

	public void setKoko(String koko) {
		this.koko = koko;
	}

	public String getMerkki() {
		return merkki;
	}

	public void setMerkki(String merkki) {
		this.merkki = merkki;
	}

	@Override
	public String toString() {
		return "Tuote " + getId() + ": " + getNimi() + " " + getKoko() + " " + getMerkki() + " " + getKuvaus() + " " + getHinta();
	}
	
	

}
