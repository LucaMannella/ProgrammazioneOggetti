package biblio;

import java.util.ArrayList;
import java.util.List;

public class Ripiano {
	
	final static int DEFAULT_BOOKS = 10;
	private int size;
	
	List<Libro> libri;
	
	/**
	* Costruisce un oggetto Ripiano in grado di contenere 10 libri.
	*/
	public Ripiano(){
		this(DEFAULT_BOOKS);
	}

	  /**
	   * Costruisce un oggetto Ripiano permettendo di specificarne i parametri.
	   * @param books - Numero di libri su ogni ripiano
	   */
	public Ripiano(int books) {
		libri = new ArrayList<Libro>();
		this.size = books;
	}

	/**
	 * Aggiunge il libro specificato nel ripano.
	 * @return <code>true</code> se l'inserimento è andato a buon fine
	 */
	public boolean add(Libro libro) {
		if(libri.size() >= this.size)
			return false;
		
		return libri.add(libro);
	}

	/**
	 * Verifica se il libro specificato si trova nel ripiano.
	 * @return <code>true</code> se il libro è presente
	 */
	public boolean contiene(Libro libro) {
		for(Libro l : this.libri) {
			if( l.equals(libro) )
				return true;
		}
		return false;
	}
	
	/**
	 * Ricerca un libro inserito nella biblioteca in base a autore e titolo. 
	 * Se uno dei due è <code>null</code> la ricerca viene fatta solo su un parametro.
	 * @return il libro ricercato o <code>null</code> se non è stato trovato alcun libro
	 */
	public Libro cerca(String autore, String titolo) {
		if((autore == null) && (titolo == null) )
			return null;
		  
		Libro toRet = null;

		for(Libro l : libri) {
			if(autore == null) {
				if(titolo.equals(l.getTitolo()))
					toRet = l;
			}
			else if(titolo == null) {
				if(autore.equals(l.getAutore()))
					toRet = l;
			}
			else {
				if( (titolo.equals(l.getTitolo())) && (autore.equals(l.getAutore())) )
					toRet = l;
			}
			
			if(toRet != null)
				break;
		}
		
		return toRet;
	}

	/**
	 * Restituisce l'elenco dei libri contenuti nel ripiano, uno per riga.
	 */
	public String getLibri() {
		String toRet = "\n";
		
		if(libri.isEmpty()) 
			return "empty.";
		
		for(Libro l : libri) {
			toRet += "\t"+l.toString()+"\n";
		}
		return toRet;
	}

	/**
	 * This method returns the number of books stored inside the shelf.
	 */
	public int getBooksNumber() {
		return libri.size();
	}
}
