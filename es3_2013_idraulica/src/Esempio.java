import idraulica.Elemento;
import idraulica.Ripartitore;
import idraulica.Rubinetto;
import idraulica.Scarico;
import idraulica.Sistema;
import idraulica.Sorgente;
import idraulica.Split;

public class Esempio {

    public static void main(String[] args) {
    	// crea il sistema
		Sistema s = new Sistema();
		
		// crea degli elementi
		Elemento el1 = new Elemento("elemento1");		
		Elemento el2 = new Elemento("elemento2");
		
		Sorgente src = new Sorgente("Src");
		src.setPortata(100);
		Elemento tap = new Rubinetto("Tap", true);		
		Elemento sink = new Scarico("Snk");
		
		Sorgente source = new Sorgente("Source");
		source.setPortata(80);
		Split t = new Split("T");
		Elemento sink1 = new Scarico("Sink 1");
		Elemento sink2 = new Scarico("Sink 2");	
		
		Sorgente source0 = new Sorgente("Source 0");
		source0.setPortata(150);
		Ripartitore par = new Ripartitore("Par", 3);
        
        // aggiunge gli elementi al sistema
		s.aggiungiElemento(el1);
		s.aggiungiElemento(el2);
		
		s.aggiungiElemento(src);
		s.aggiungiElemento(tap);
		s.aggiungiElemento(sink);
		
		s.aggiungiElemento(source);
		s.aggiungiElemento(t);
		s.aggiungiElemento(sink1);
		s.aggiungiElemento(sink2);
		
		s.aggiungiElemento(source0);
		s.aggiungiElemento(par);
		
		// connetto gli elementi
		src.connetti(tap);
		tap.connetti(sink);
		
		source.connetti(t);
		t.connetti(sink1, 0);
		t.connetti(sink2, 1);
		
		source0.connetti(par);
		par.connetti(sink, 0);
		par.connetti(sink1, 1);
		par.connetti(sink2, 2);
		double prop[] = {33, 40, 25};
		par.setProporzioni( prop );
		
		// controllo connessione
		System.out.println("Connessioni nel sistema: ");
		System.out.println("L'elemento "+src.getNome()+" è connesso a "+src.getUscita().getNome());
		System.out.println("L'elemento "+tap.getNome()+" è connesso a "+tap.getUscita().getNome()+"\n");
		
		System.out.println("L'elemento "+source.getNome()+" è connesso a "+source.getUscita().getNome());
		for(Elemento e : t.getUscite()) {
			System.out.println("L'elemento "+t.getNome()+" è connesso a "+e.getNome());
		}
		System.out.println();
		
		System.out.println("L'elemento "+source0.getNome()+" è connesso a "+source0.getUscita().getNome());
		for(Elemento e : par.getUscite()) {
			System.out.println("L'elemento "+par.getNome()+" è connesso a "+e.getNome());
		}
		System.out.println();
        
        // Stampo gli elementi del sistema       
        System.out.println("Il sistema contiene: ");
        System.out.println(s.toString());
        
        s.simula();
    }

}
