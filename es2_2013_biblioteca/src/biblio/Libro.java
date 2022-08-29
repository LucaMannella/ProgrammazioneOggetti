package biblio;

public class Libro implements Comparable<Libro>{
	
	private String author;
	private String title;
	private int floor;
	private String bookcase;
	private int shelf;
	
	/**
	 * Costruisce un libro a partire da autore e titolo.
	 */
	public Libro(String autore, String titolo) {
		this.author = autore;
		this.title = titolo;
	}
	
	public boolean equals(Object otherBook) {
		Libro other = (Libro) otherBook;
		
		if( ! title.equals(other.getTitolo()) )
			return false;
		if( ! author.equals(other.getAutore()) )
			return false;
		
		return true;
	}

	@Override
	public int compareTo(Libro o) {
		int toRet;
		
		toRet = title.compareTo(o.getTitolo());
		if(toRet == 0)
			toRet = author.compareTo(o.getAutore());
		
		return toRet;
	}

	/**
	 * Restitiuisce la string corrispondente al libro nella forma "autore, titolo".
	 */
	public String toString() {
		return author+", "+title;
	}

/* -.-.-.-.-.- Getter and Setter Methods -.-.-.-.-.- */
	/**
	 * Metodo <i>getter</i> per accedere all'autore del libro.
	 */
	public String getAutore() {
		return author;
	}

	/**
	 * Metodo <i>getter</i> per accedere al titolo del libro.
	 */
	public String getTitolo() {
		return title;
	}
	
	/**
	 * Restituisce il numero del ripiano in cui si trova il libro.
	 */
	public int getRipiano() {
		return this.shelf;
	}

	/**
	 * Restituisce il codice dello scaffale in cui si trova il libro.
	 */
	public String getScaffale() {
		return this.bookcase;
	}

	/**
	 * Restituisce il numero del piano in cui si trova il libro.
	 */
	public int getPiano() {
		return this.floor;
	}

	/**
	 * Imposta il numero del piano in cui si trova il libro.
	 */
	public void setPiano(int floor) {
		this.floor = floor;
	}
	
	/**
	 * Imposta il numero del ripiano in cui si trova il libro.
	 */
	public void setRipiano(int shelf) {
		this.shelf = shelf;
	}

	/**
	 * Imposta il codice dello scaffale in cui si trova il libro.
	 */
	public void setScaffale(String bookcase) {
		this.bookcase = bookcase;
	}
}
