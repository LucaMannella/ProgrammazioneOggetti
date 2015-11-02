package rubrica;

public class Voce {
	
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
	
	public String toString() {
		return name+" "+surname+" "+cell;
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
