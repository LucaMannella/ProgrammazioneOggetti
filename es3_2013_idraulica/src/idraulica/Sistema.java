package idraulica;

import java.util.LinkedList;
import java.util.List;

public class Sistema {

	private List<Elemento> elementi = new LinkedList<Elemento>();
	
	public void aggiungiElemento(Elemento elem) {
		elementi.add(elem);
	}
	
	public Elemento[] getElementi(){
		Elemento toRet[] = new Elemento[elementi.size()];
		elementi.toArray(toRet);
		return toRet;
	}
	
	/**
	 * This method returns a String that contains all the elements of the system, an element for each line.
	 */
	public String toString() {
		String toRet = "";
		for(Elemento el : elementi) {
			toRet += "\t"+el.getNome()+"\n";
		}
		return toRet;
	}

	public void simula(){
		for(Elemento el : elementi) {
			if(el instanceof Sorgente) {
				Sorgente s = (Sorgente) el;
				s.simula(null);
			}
		}
	}
}
