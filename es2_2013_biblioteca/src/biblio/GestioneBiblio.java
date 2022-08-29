package biblio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * This class allows to manage a Library.<BR>
 * For using this class is recommended to check the constants ADD, LIST, LIBRO, QUIT.
 */
public class GestioneBiblio {
	
	public final static String ADD="add";
	public final static String LIST="list";
	public final static String LIBRO="libro";
	public final static String QUIT="quit";
	
	private Biblioteca library;

	public GestioneBiblio() {
		this.library = new Biblioteca();
	}
	
	public GestioneBiblio(int floor, int bookcases, int shelves, int books) {
		this.library = new Biblioteca(floor, bookcases, shelves, books);
	}
	
	public GestioneBiblio(Biblioteca biblio) {
		this.library = biblio;
	}

	public void start() throws IOException {
		String cmd;
		String author, title, bookcase;
		int floor, shelf;
		//StringTokenizer st;
		//String user = JOptionPane.showInputDialog("Please enter your name: ");
		
		BufferedReader stdin;
		InputStreamReader keyboard;
		try {
			keyboard = new InputStreamReader(System.in, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.err.println("Impossible to set the specified Encoding "+e.getMessage());
			keyboard = new InputStreamReader(System.in);
		}
		stdin = new BufferedReader(keyboard);
				
		do {
			System.out.println("Enter a command");
			System.out.println("> ");
			//System.out.print(user+"@library$ > ");
			cmd = stdin.readLine();
			switch (cmd) {
				case ADD:	//inserimento libro
					System.out.println("Enter the author: ");
					author = stdin.readLine();
					System.out.println("Enter the title: ");
					title = stdin.readLine();
					
					System.out.println("Enter the floor: ");
					floor = Integer.valueOf(stdin.readLine());
					System.out.println("Enter the bookcase (\"SCxx\"): ");
					bookcase = stdin.readLine();	
					System.out.println("Enter the shelf: ");
					shelf = Integer.valueOf(stdin.readLine());
					
					Libro book = new Libro(author, title);
					
					if( library.add(book, floor, bookcase, shelf) == true )
						System.out.println("The insertion has been successful!");
					else
						System.out.println("Something wrong has happened during the insertion...");
					
					break;
					
				case LIST:	//stampa contenuto scaffale
					System.out.println("Enter the floor: ");
					floor = Integer.valueOf(stdin.readLine());
					System.out.println("Enter the bookcase (\"SCxx\"): ");
					bookcase = stdin.readLine();	
					
					String list = library.getLibri(floor, bookcase);
					System.out.println(list);
					break;
					
				case LIBRO:	//ricerca un libro e stampa la posizione
					System.out.println("Enter the author: ");
					author = stdin.readLine();
					System.out.println("Enter the title: ");
					title = stdin.readLine();
					
					book = library.cerca(author, title);
					if(book==null  )
						System.out.println("The book is not inside the library!");
					else
						System.out.println("The book was found! \nIt is located on floor "
								+book.getPiano()+ " in the bookcase "+book.getScaffale()+" on the shelf "+book.getRipiano());					
					
					break;
					
				case QUIT:
					System.out.println(QUIT+" received... The program will exit.");
					break;
	
				default:
					System.out.println(cmd+" is an invalid command...\nPlease try again...");
			}

		} while(!cmd.equals(QUIT));
		
		System.out.println("The program has ended.");
		return;
	}

    public static void main(String[] args) throws IOException {
        Biblioteca biblio = new Biblioteca();
        GestioneBiblio ui = new GestioneBiblio(biblio);
        ui.start();
    }
}
