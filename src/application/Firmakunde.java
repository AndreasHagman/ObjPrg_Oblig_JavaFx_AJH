package application;

public class Firmakunde extends Kunde {
	private String kredittgrense;
	private String tlfnr;
	
	
	public Firmakunde(String navn, String kundenr, String kredittgrense, String tlfnr) {
		super(navn, kundenr);
		this.kredittgrense = kredittgrense;
		this.tlfnr = tlfnr;
	}
	
	public String getKredittgrense() {
		return kredittgrense;
	}
	public void setKredittgrense(String kredittgrense) {
		this.kredittgrense = kredittgrense;
	}
	public String getTlfnr() {
		return tlfnr;
	}
	public void setTlfnr(String tlfnr) {
		this.tlfnr = tlfnr;
	}

	@Override
	public String toString() {
		return "Firmakunde [kredittgrense=" + kredittgrense + ", tlfnr=" + tlfnr + ", getNavn()=" + getNavn()
				+ ", getKundenr()=" + getKundenr() + "]";
	}
	
	
	
}
