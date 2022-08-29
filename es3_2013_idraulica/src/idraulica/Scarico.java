package idraulica;

public class Scarico extends Elemento {

	public Scarico(String nome) {
		super(nome);
	}
	
	/**
	 * This method is disabled for a sink and does not work.
	 */
	public void connetti(Elemento elem) {
		System.err.println("It is not possible to connect a Sink to something.");
	}

	public void simula(String indentation, double portata) {
		System.out.println(indentation+" | ");
		System.out.println(indentation+" element: "+name+" - inflow: "+portata+" cubic meters per second");
		System.out.println(indentation+" End of the Flow - ");
		System.out.println(indentation);
	}

}
