package biblio;

public class Scaffale {

	final static int DEFAULT_SHELVES = 6;
	Ripiano ripiani[];
	
	/**
	* Costruisce un oggetto Scaffale con 6 ripiani,
	* ciascun ripiano ha posto per 10 libri.
	*/
	public Scaffale(){
		this(DEFAULT_SHELVES, Ripiano.DEFAULT_BOOKS);
	}

	/**
	 * Costruisce un oggetto Scaffale permettendo di specificarne i parametri.
	 * @param shelves - Numero di ripiani per ogni scaffale
	 * @param books - Numero di libri su ogni ripiano
	 */
	public Scaffale(int shelves, int books) {
		ripiani = new Ripiano[shelves];
		
		for(int i=0; i<shelves; i++) {
			this.ripiani[i] = new Ripiano(books);
		}
	}

	/**
	 * Verifica se il libro specificato si trova al ripiano dato.
	 * @return <code>true</code> se il libro è presente
	 */
	public boolean contiene(int ripiano, Libro libro) {
		if( (ripiano < 0) || (ripiano >= ripiani.length) )
			return false;
		return this.ripiani[ripiano].contiene(libro);
	}

	/**
	 * Aggiunge il libro specificato nel ripano specificato.
	 * @return <code>true</code> se l'inserimento è andato a buon fine
	 */
	public boolean add(Libro libro, int ripiano) {
		if((ripiano < 0) || (ripiano>=ripiani.length))
			return false;
		
		if( ripiani[ripiano].add(libro) == true ) {
			libro.setRipiano(ripiano);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * This method transform the code of a bookcase in the relative integer value.
	 * @param bookcase - The code of the bookcase
	 * @return - The integer value related to that code
	 */
	public static int toInteger(String bookcase) {
		bookcase = bookcase.substring(2);
		return Integer.valueOf(bookcase);
	}

	/**
	 * Ricerca un libro inserito nella biblioteca in base a autore e titolo. 
	 * Se uno dei due è <code>null</code> la ricerca viene fatta solo su un parametro.
	 * @return il libro ricercato o <code>null</code> se non è stato trovato alcun libro
	 */
	public Libro cerca(String autore, String titolo) {
		Libro toRet = null;
		  
		for(int i=0; i<ripiani.length; i++) {
			toRet = ripiani[i].cerca(autore, titolo);
			  
			if(toRet != null)
				return toRet;
		}
		  
		return toRet;
	}

	/**
	 * Restituisce l'elenco dei libri contenuti nello scaffale.
	 * Per ogni ripiano nella stringa compare l'indicazione del 
	 * ripiano nella forma "Ripiano 1" seguito, nelle righe 
	 * successive dai libri contenuti nel ripiano.
	 */
	public String getLibri() {
		String toRet="";
		int i;
		
		for(i=0; i<ripiani.length; i++) {
			if(ripiani[i] != null)
				toRet += "Ripiano "+i+" "+ripiani[i].getLibri()+"\n";
		}
		
		return toRet;
	}
}
