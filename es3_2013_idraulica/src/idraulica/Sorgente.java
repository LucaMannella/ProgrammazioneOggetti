package idraulica;

public class Sorgente extends Elemento {

	private double portata;

	public Sorgente(String nome) {
		super(nome);
	}
	
	public Sorgente(String nome, double portata) {
		super(nome);
		this.portata = portata;
	}

	public void setPortata(double portata){
		this.portata = portata;
	}
	
	public void simula(String indentation){
		System.out.println("\nSource: "+super.name+" - Flow: "+this.portata+" cubic meters per second");
		super.output.simula("---", this.portata);
	}
}
