package rubrica;

public class Voce implements Comparable<Voce>{
	
	private String name;
	private String surname;
	private String cell;

	public Voce(String name, String surname, String cell) {
		this.name = name;
		this.surname = surname;
		this.cell = cell;
	}
	
	public boolean rename (String name, String surname, String cell) {
		this.name = name;
		this.surname = surname;
		this.cell = cell;
		return true;
	}
	
	@Override
	public String toString() {
		return name+" "+surname+" "+cell;
	}
	
	@Override
	public boolean equals(Object o) {
		Voce other = (Voce) o;
		
		if(!this.surname.equals(other.getSurname()))
			return false;
		if(!this.name.equals(other.getName()))
			return false;
		if(!this.cell.equals(other.getCell()))
			return false;
		
		return true;
	}

	@Override
	public int compareTo(Voce other) {
		int toRet = this.surname.compareTo(other.getSurname());
		
		if(toRet == 0) {
			toRet = this.name.compareTo(other.getName());
			if(toRet == 0)
				toRet = this.cell.compareTo(other.getCell());
		}
		return toRet;
	}

	/* -.-.-.-.-.- Setters Methods -.-.-.-.-.- */
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getCell() {
		return cell;
	}
	
}
