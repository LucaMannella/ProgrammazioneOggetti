package rubrica;

import java.util.ArrayList;
import java.util.List;

public class Rubrica {

	private String name;
	private List<Voce> voci;
	
	public Rubrica (String name) {
		this.name = name;
		this.voci = new ArrayList<Voce>();
	}
	
	/** This method add a new element inside the phonebook **/
	public boolean aggiungi(String nome, String cognome, String cell) {
		Voce v = new Voce(nome,cognome,cell);
		return voci.add(v);
	}
	
	/** This method returns the first element of the phonebook in String form. **/
	public String primo() {		
		if (voci.size() == 0)
			return null;
		
		return voci.get(0).toString();
	}
	
	/** This method returns the last element of the phonebook in String form. **/
	public String ultimo() {
		int dim = voci.size();
		if (dim == 0)
			return null;
		
		return voci.get(dim-1).toString();	
	}
	
	/** This method returns the element of the phonebook in position N in String form. **/
	public String voce(int n) {
		try {
			return voci.get(n-1).toString();
		}
		catch(IndexOutOfBoundsException e) {
			System.err.println("Out of bound exception caught! Check input value!");
			return null;
		}
		catch(Exception e1) {
			System.err.println("Unaspected exception!");
			return null;
		}
		
	}
	
	/** This method return the entire contents of the phonebook and its syntax is:<br>
	 * (<i>name surname cell,<br>
	 * <i>name surname cell,<br>
	* <i>name surname cell)**/
	public String elenco() {
		String toRet = "(";
		int i=0;
		for (i=0; i < voci.size()-1; i++) {
			toRet += voci.get(i).toString()+",\n";
		}
		toRet += voci.get(i).toString()+")";
		return toRet;
	}
	
	/** This method look for the specified string inside all names, surnames and cell numbers.
	 * @param toFind - The string to find. 
	 * @return It returns <i>null</i> if it does not find any result.**/
	public String ricerca(String toFind) {
		for(Voce v : voci){
			if(toFind.equals(v.getName()))
				return v.toString();
			else if(toFind.equals(v.getSurname()))
				return v.toString();
			else if(toFind.equals(v.getCell()))
				return v.toString();
		}
		
		return null;
	}

/* -.-.-.-.-.- Getter and Setter Methods -.-.-.-.-.- */
	public int getBookSize() {
		return voci.size();
	}
	
	public String getNome() {
		return name;
	}
	
	/** This method is equivalent to <i>setName(String name);</i> **/
	public boolean rename(String name) {
		this.name = name;
		return true;
	}
}
