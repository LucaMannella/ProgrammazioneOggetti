package biblio;

public class Piano {
	
	final static int DEFAULT_BOOKCASES = 30;
	Scaffale scaffali[];
	
	/**
	* Costruisce un oggetto piano con 30 scaffali,
	* ogni scaffale ha 6 ripiani e ciascuno di essi ha posto per 10 libri.
	*/
	public Piano() {
		this(DEFAULT_BOOKCASES, Scaffale.DEFAULT_SHELVES, Ripiano.DEFAULT_BOOKS);
	}

	/**
	 * Costruisce un oggetto Piano permettendo di specificarne i parametri.
	 * @param bookcase - Numero di scaffali per piano
	 * @param shelves - Numero di ripiani per ogni scaffale
	 * @param books - Numero di libri su ogni ripiano
	 */
	public Piano(int bookcases, int shelves, int books) {
		scaffali = new Scaffale[bookcases];
		
		for(int i=0; i<bookcases; i++) {
			this.scaffali[i] = new Scaffale(shelves, books);
		}
	}

	/**
	 * Aggiunge il libro specificato nel ripano e scaffale specificati.
	 * @return <code>true</code> se l'inserimento è andato a buon fine
	 */
	public boolean add(Libro libro, String scaffale, int ripiano) {
		int bookcase = Scaffale.toInteger(scaffale);
		
		if((bookcase < 0) || (bookcase >= scaffali.length))
			return false;
		
		if( scaffali[bookcase].add(libro, ripiano) == true ) {
			libro.setScaffale(scaffale);
			return true;
		}
		else
			return false;
	}

	/**
	 * Verifica se il libro specificato si trova al ripiano e scaffale dati.
	 * @return <code>true</code> se il libro è presente
	 */
	public boolean contiene(String scaffale, int ripiano, Libro libro) {
		int bookcase = Scaffale.toInteger(scaffale);
		if( (bookcase < 0) || (bookcase >= scaffali.length) )
			return false;
		//else System.out.println("LOG - Il codice dello scaffale è: "+bookcase+"\n");
		
		return this.scaffali[bookcase].contiene(ripiano, libro);
	}

	/**
	 * Ricerca un libro inserito nella biblioteca in base a autore e titolo. 
	 * Se uno dei due è <code>null</code> la ricerca viene fatta solo su un parametro.
	 * @return il libro ricercato o <code>null</code> se non è stato trovato alcun libro
	 */
	public Libro cerca(String autore, String titolo) {
		Libro toRet = null;
		  
		for(int i=0; i<scaffali.length; i++) {
			toRet = scaffali[i].cerca(autore, titolo);
			  
			if(toRet != null)
				return toRet;
		}
		  
		return toRet;
	}

	/**
	 * Restituisce l'elenco dei libri contenuti nello scaffale specificato.
	 * Per ogni ripiano nella stringa compare l'indicazione del 
	 * ripiano nella forma "Ripiano 1" seguito, nelle righe 
	 * successive dai libri contenuti nel ripiano.
	 */
	public String getLibri(String scaffale) {
		int bookcase = Scaffale.toInteger(scaffale);
		if( (bookcase < 0) || (bookcase >= scaffali.length) )
			return "Invalid bookcase!\n";
		
		return scaffali[Scaffale.toInteger(scaffale)].getLibri();
	}

}
