package ateneo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Studente implements Comparable<Studente>{

	private static final int MAX_COURSES = 25;
	
	private int ID;
	private String name;
	private String surname;
	private Map<Integer, Corso> corsi;
	
	public Studente(int studentID, String studentName, String studentSurname) {
		this.ID = studentID;
		this.name = studentName;
		this.surname = studentSurname;
		this.corsi = new HashMap<Integer, Corso>();
	}
	
	public String toString() {
		return ID+" "+name+" "+surname;
	}

	@Override
	public boolean equals(Object o) {
		Studente other = (Studente) o;
		
		if( this.ID != other.getStudentID() )
			return false;
		if(!this.surname.equals( other.getSurname()) )
			return false;
		if(!this.name.equals( other.getName()) )
			return false;
		
		return true;
	}

	@Override
	public int compareTo(Studente other) {
		int toRet = this.surname.compareTo( other.getSurname() );
		
		if(toRet == 0) {
			toRet = this.name.compareTo( other.getName() );
			if(toRet == 0) {
				toRet = this.ID - other.getStudentID();
			}
		}
		return toRet;
	}
	
	/** This method enrolls the student in a course.
	 * @return - False if the MAX number of courses was reached, True otherwise.
	 */
	public boolean addCourse(Corso c) {
		if(corsi.size() >= MAX_COURSES)
			return false;
		
		corsi.put(c.getCourseID(), c);
		return true;
	}
	
	public void removeCourse(int courseID) {
		corsi.remove(courseID);
	}

	/* -.-.-.-.-.- Getter and Setter Methods -.-.-.-.-.- */
	public int getStudentID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}
	
	public Collection<Corso> getCourses() {
		return corsi.values();
	}
}
