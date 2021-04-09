package application;

public abstract class Kunde {
	private String navn;
	private String kundenr;
	
	
	public Kunde(String navn, String kundenr) {
		super();
		this.navn = navn;
		this.kundenr = kundenr;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public String getKundenr() {
		return kundenr;
	}
	public void setKundenr(String kundenr) {
		this.kundenr = kundenr;
	}
	
	
	@Override
	public String toString() {
		return "Kunde [navn=" + navn + ", kundenr=" + kundenr + "]";
	}
	
	
	
	
}

