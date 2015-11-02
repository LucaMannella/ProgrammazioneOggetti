import rubrica.Rubrica;

/**
 * Classe con un main di esempio.
 */
public class Principale {

    /**
     * Esempio di uso della classe Rubrica.
     * Può essere utilizzato come semplice "test"
     * 
     */
	public static void main(String[] args) {
		
		// Quando si crea un oggetto Rubrica si deve fornire un nome 
		Rubrica r = new Rubrica("Luke's book"); // CREAZIONE 
		
		//...che è poi accessibile tramite il metodo getNome().
		String nomeRubrica = r.getNome();
		System.out.println("Creata rubrica con nome " + nomeRubrica);
		
		// L'inserimento di una nuova voce nella rubrica avviene 
		// tramite il metodo aggiungi() che riceve tre parametri
		// stringa: nome, cognome, e telefono.
		r.aggiungi("Mario","Rossi","321 98 76");
		r.aggiungi("Giovanni","Bianchi","123 45 67");
		r.aggiungi("Giuseppe","Verdi","456 789 123");
		r.aggiungi("Bruce","Wayne","338 789 321");
		r.aggiungi("Luca","Mannella","333 98 91");
		
		// Per accedere al primo e all'ultimo elemento della rubrica si 
		// utilizzano i metodi primo() e ultimo()
		String primaVoce = r.primo();
		System.out.println("primo() --> " + primaVoce);
		String ultimaVoce = r.ultimo();
		System.out.println("ultimo() --> "+ultimaVoce+"\n");
		
		// Il metodo elenco() restituisce una stringa con 
		// l'elenco delle voci della rubrica separate da ", "; 
		// l'elenco inizia con "(" e termina con ")".
		// (inoltre il metodo elenco applica l'ordinamento)
		System.out.println("Elenco: " + r.elenco() + "\n");
		
		// Per accedere ad un elemento qualsiasi nella rubrica si utilizza 
		// il metodo voce() che riceve come parametro il numero d'ordine della voce 
		// (a partire da 1, perciò primo() == voce(1));
		// (possiamo osservare come l'ordinamento ha variato permanentemente l'ordine di inserimento)
		int N = r.getBookSize();
		for(int i=1; i<(N+1); i++)
			System.out.println("voce("+i+") --> " + r.voce(i));
		System.out.println();
		
		// il metodo ricerca() restituisce la stringa 
		// corrispondente alla prima voce che contiene il 
		// parametro come nome, cognome oppure telefono
		String toFind = "Wayne";
		String result = r.ricerca(toFind);
		if(result == null)
			result = "...No result was found...";
		System.out.println("Ricerca '"+toFind+"': "+result+"\n");
		
		//provo il metodo toString() della rubrica
		System.out.println(r);
	}
	
}
