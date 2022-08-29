import java.util.ArrayList;
import java.util.List;

import ateneo.Ateneo;

/**
 * Classe con un main di esempio.
 */
public class Esempio {

	public static void main(String[] args) {
		Integer stud;
		List<Integer> studenti = new ArrayList<Integer>();
		
		Ateneo poli = new Ateneo("Politecnico di Torino");
		
		poli.setRettore("Francesco", "Profumo");
		
		System.out.println("Rettore del " + poli.getNome() + " : " + poli.getRettore());
		
		stud = poli.immatricola("Mario","Rossi");
		studenti.add(stud);
		stud = poli.immatricola("Giuseppe","Verdi");
		studenti.add(stud);
		stud = poli.immatricola("Luca","Mannella");
		studenti.add(stud);
		stud = poli.immatricola("Bruce","Wayne");
		studenti.add(stud);
		stud = poli.immatricola("Mister","Brown");
		studenti.add(stud);
		stud = poli.immatricola("Bruce","Wayne");
		if(stud>0)
			studenti.add(stud);
		stud = poli.immatricola("Edo","Riva");
		if(stud>0)
			studenti.add(stud);
		
		int i=1;
		System.out.println("Inseriti studenti ");
		for(Integer s : studenti) {
			System.out.println("s"+i+" = "+poli.studente(s));
			i++;
		}
		System.out.println();
		
		int cod = poli.attiva("Macro economia", "Paul Krugman");
		poli.iscrivi(studenti.get(6), cod);
		poli.iscrivi(studenti.get(1), cod);
		poli.iscrivi(studenti.get(3), cod);
		System.out.println("Elenco iscritti al corso: "+poli.insegnamento(cod));	
		System.out.println(poli.elencoIscritti(cod));
		
		cod = poli.attiva("Software Engineering", "Giorgio Bruno");
		poli.iscrivi(studenti.get(2), cod);
		poli.iscrivi(studenti.get(4), cod);
		poli.iscrivi(studenti.get(5), cod);
		System.out.println("Elenco iscritti al corso: "+poli.insegnamento(cod));	
		System.out.println(poli.elencoIscritti(cod));

		cod = poli.attiva("Object Oriented Programming", "Giorgio Bruno");
		poli.iscrivi(studenti.get(0), cod);
		poli.iscrivi(studenti.get(1), cod);
		poli.iscrivi(studenti.get(2), cod);
		System.out.println("Elenco iscritti al corso: "+poli.insegnamento(cod));	
		System.out.println(poli.elencoIscritti(cod));
	}
}
