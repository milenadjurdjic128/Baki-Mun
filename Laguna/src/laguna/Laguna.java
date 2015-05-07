package laguna;

public class Laguna {

	
	private String nazivKnjige;
	private String pisac;
	private String izdavac;
	private String zanr;
	
	public String getNazivKnjige() {
		return nazivKnjige;
	}
	public void setNazivKnjige(String nazivKnjige) {
		this.nazivKnjige = nazivKnjige;
	}
	public String getPisac() {
		return pisac;
	}
	public void setPisac(String pisac) {
		this.pisac = pisac;
	}
	public String getIzdavac() {
		return izdavac;
	}
	public void setIzdavac(String izdavac) {
		this.izdavac = izdavac;
	}
	public String getZanr() {
		return zanr;
	}
	public void setZanr(String zanr) {
		this.zanr = zanr;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Laguna) {
			Laguna k = (Laguna) o;
			if(nazivKnjige.equals(k.getNazivKnjige()) && pisac.equals(k.getPisac()) && izdavac.equals(k.getIzdavac()) 
					&& zanr.equals(k.getZanr()));
			return true;
			
		}
		return false;
	}
	
	
	@Override
	public String toString() {
		return "Naziv: " + nazivKnjige + "\n" + "Pisac: " + pisac + "\n" + "Izdavac: " + 
				izdavac + "\n" + "Zanr: " + zanr + "\n";
	}
	
	
	
}
