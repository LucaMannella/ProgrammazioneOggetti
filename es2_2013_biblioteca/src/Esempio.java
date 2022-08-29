import biblio.Biblioteca;
import biblio.Libro;

public class Esempio {

    public static void main(String[] args) {
        // crea la biblioteca
        Biblioteca biblio = new Biblioteca();
        
        // crea dei libri
        Libro manzoni = new Libro("A. Manzoni","I Promessi Sposi");
        Libro pennac = new Libro("Daniel Pennac","La Fata Carabina");
        Libro dodo = new Libro("Dan Don", "Azkebefenai");
        Libro manne = new Libro("Luca Mannella", "La guerra di Sarcares");
        Libro lesci = new Libro("Luca Lesci", "How to be Cusci");
        Libro mm = new Libro("Mat-Man", "Il pompiere paura non ne ha!");
        
        // aggiunge i libri alla biblioteca
        biblio.add(manzoni,	1, "SC29", 0);
        biblio.add(pennac,	1, "SC29", 1);
        biblio.add(dodo, 	1, "SC29", 2);
        biblio.add(manne, 	1, "SC29", 3);
        biblio.add(lesci, 	1, "SC29", 4);
        biblio.add(manzoni,	1, "SC29", 5);
        biblio.add(pennac,	1, "SC29", 6);
        biblio.add(dodo, 	1, "SC29", 5);
        biblio.add(manne, 	1, "SC29", 4);
        biblio.add(lesci, 	1, "SC29", 3);
        biblio.add(manzoni,	1, "SC29", 2);
        biblio.add(pennac,	1, "SC29", 1);
        biblio.add(dodo, 	1, "SC29", 0);
        biblio.add(manne, 	1, "SC29", 1);
        biblio.add(lesci, 	1, "SC29", 2);
        biblio.add(manzoni,	1, "SC29",-1);
        biblio.add(pennac,	1, "SC29", 0);
        biblio.add(dodo, 	1, "SC29", 1);
        biblio.add(manne, 	1, "SC29", 2);
        
        // cerco i libri nella biblioteca
        if( biblio.contiene(1,"SC29",4,manzoni) )
        	System.out.println("\""+manzoni+"\" is in the specified place.");
        else
        	System.out.println("\""+manzoni+"\" is not in the specified place.");
        
        if( biblio.contiene(2,"SC1",4,manzoni) )
        	System.out.println("\""+manzoni+"\" is in the specified place.");
        else
        	System.out.println("\""+manzoni+"\" is not in the specified place.");
        
        if( biblio.contiene(1,"SC29",1,pennac) )
        	System.out.println("\""+pennac+"\" is in the specified place.");
        else
        	System.out.println("\""+pennac+"\" is not in the specified place.");
        
        if( biblio.contiene(1,"SC29",3,dodo) )
        	System.out.println("\""+dodo+"\" is in the specified place.");
        else
        	System.out.println("\""+dodo+"\" is not in the specified place.");
        
        String elenco = biblio.getLibri(1,"SC29");
        System.out.println("\n"+elenco);
        
        Libro l = biblio.cerca(manzoni.getAutore(), manzoni.getTitolo());
        if(l == null)
        	System.out.println("\""+manzoni+"\" not found!");
        else
        	System.out.println("\""+manzoni+"\" is located into the floor "+manzoni.getPiano()
        			+" in the bookcase "+manzoni.getScaffale()+" on the shelf "+manzoni.getRipiano()+".");
        
        l = biblio.cerca(mm.getAutore(), mm.getTitolo());
        if(l == null)
        	System.out.println("\""+mm+"\" not found!");
        else
        	System.out.println("\""+mm+"\" is located into the floor "+mm.getPiano()
        			+" in the bookcase "+mm.getScaffale()+" on the shelf "+mm.getRipiano()+".");
    }

}
