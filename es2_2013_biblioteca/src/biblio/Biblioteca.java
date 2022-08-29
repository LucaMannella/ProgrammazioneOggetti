package biblio;

public class Biblioteca {
	
	final static int DEFAULT_FLOORS = 3;
	Piano piani[];

  /**
   * Costruisce un oggetto Biblioteca con 3 piani, 
   * 30 scaffali per piano, 6 ripiani per scaffale
   * ciascuno con posto per 10 libri.
   */
  public Biblioteca() {
	  this(DEFAULT_FLOORS, Piano.DEFAULT_BOOKCASES, Scaffale.DEFAULT_SHELVES, Ripiano.DEFAULT_BOOKS);
  }
  
  /**
   * Costruisce un oggetto Biblioteca permettendo di specificarne i parametri.
   * @param floors - Numero di Piani della biblioteca
   * @param bookcase - Numero di scaffali per piano
   * @param shelves - Numero di ripiani per ogni scaffale
   * @param books - Numero di libri su ogni ripiano
   */
  public Biblioteca(int floors, int bookcases, int shelves, int books) {
	  this.piani = new Piano[floors];
	  
	  for(int i=0; i<floors; i++) {
		  this.piani[i] = new Piano(bookcases, shelves, books);
	  }
  }
  
  /**
   * Aggiunge il libro specificato nel ripano, scaffale e piano specificati.
   * @return <code>true</code> se l'inserimento è andato a buon fine
   */
  public boolean add(Libro libro, int piano, String scaffale, int ripiano) {
	  if((piano < 0) || (piano >= piani.length))
		  return false;
	  
	  if( piani[piano].add(libro, scaffale, ripiano) == true ) {
		  libro.setPiano(piano);
		  return true;
	  }
	  else
		  return false;
  }

  /**
   * Verifica se il libro specificato si trova al
   * ripiano, scaffale e piano dati
   * @return <code>true</code> se il libro è presente
   */
  public boolean contiene(int piano, String scaffale, int ripiano, Libro libro) {
	  if( (piano < 0) || (piano >= piani.length) )
		  return false;
	  
	  return this.piani[piano].contiene(scaffale, ripiano, libro);
  }

  /**
   * Restituisce l'elenco dei libri contenuti in uno scaffale.
   * Per ogni ripiano nella stringa compare l'indicazione del 
   * ripiano nella forma "Ripiano 1" seguito, nelle righe 
   * successive dai libri contenuti nel ripiano.
   */
  public String getLibri(int piano, String scaffale) {
	  if( (piano < 0) || (piano >= piani.length) )
		  return "Invalid Floor!\n";
	  
	  return piani[piano].getLibri(scaffale);
  }

  /**
   * Ricerca un libro inserito nella biblioteca in base a autore e titolo. 
   * Se uno dei due è <code>null</code> la ricerca viene fatta solo su un parametro.
   * @return il libro ricercato o <code>null</code> se non è stato trovato alcun libro
   */
  public Libro cerca(String autore, String titolo) {
	  Libro toRet = null;
	  
	  for(int i=0; i<piani.length; i++) {
		  toRet = piani[i].cerca(autore, titolo);
		  
		  if(toRet != null)
			  return toRet;
	  }
	  
	  return toRet;
  }
}
