package ateneo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Ateneo {
	
	private static final int MAX_STUDENTS = 1000;
	private static final int MAX_COURSES = 5;

	private String universityName;
	private String rectorName;
	private String rectorSurname;
	
	private int studentID = 9999;	//the student ID must start from 10000
	private Map<Integer, Studente> studenti;
	
	private int courseID = 9;		//the subject ID must start from 10
	private Map<Integer, Corso> corsi;

/* -.-.-.-.-.- Constructor Methods -.-.-.-.-.- */
	public Ateneo(String universityName) {
		this.universityName = universityName;
		this.studenti = new HashMap<Integer, Studente>();
		this.corsi = new HashMap<Integer, Corso>();
	}
	
	public Ateneo(String universityName, String rectorName, String rectorSurname) {
		this.universityName = universityName;
		this.rectorName = rectorName;
		this.rectorSurname = rectorSurname;
		this.studenti = new HashMap<Integer, Studente>();
		this.corsi = new HashMap<Integer, Corso>();
	}

/* -.-.-.-.-.- Getter and Setter Methods -.-.-.-.-.- */
	public void setRettore(String name, String surname) {
		this.rectorName = name;
		this.rectorSurname = surname;
	}

	public String getRettore() {
		return rectorName+" "+rectorSurname;
	}

	public String getNome() {
		return this.universityName;
	}

/* -.-.-.-.-.- Logic Methods -.-.-.-.-.- */
	/** This method enrolls a new student.
	 * @return - If the method fails return -1 otherwise it returns the Student ID of the new enrolled student. 
	 */
	public int immatricola(String studentName, String studentSurname) {
		if(studenti.size() >= MAX_STUDENTS)
			return -1;

		studentID++;
		Studente s = new Studente(studentID, studentName, studentSurname);
		studenti.put(studentID, s);
		return studentID;
	}

	public String studente(int studentID) {
		return studenti.get(studentID).toString();
	}

	/** This method activates a new course.
	 * @return - If the method fails return -1 otherwise it returns the Course ID of the new course. 
	 */
	public int attiva(String subject, String teacher) {
		if( corsi.size() >= MAX_COURSES )
			return -1;
		
		courseID++;
		Corso c = new Corso(courseID, subject, teacher);
		corsi.put(courseID, c);
		return courseID;
	}
	
	public String insegnamento(int courseID){
		return corsi.get(courseID).toString();
	}

	public boolean iscrivi(int studentID, int courseID) {
		Studente s = studenti.get(studentID);
		Corso c = corsi.get(courseID);
		if( s==null || c==null ) {
			System.err.println("Some data are wrong!");
			return false;
		}
		if( s.addCourse(c) == false ) {
			System.err.println("No more courses are allowed for this student!");
			return false;
		}
		else if( c.addStudent(s) == false ) {
			System.err.println("No more students are allowed for this course!");
			s.removeCourse(courseID);
			return false;
		}
		
		return true;
	}

	public String elencoIscritti(int courseID) {	
		Corso c = corsi.get(courseID);
		Collection<Studente> subscribed = c.getStudents();
		String toRet = "";
		
		for(Studente s : subscribed)
			toRet += s.toString()+"\n";
		
		return toRet;
	}
	
	public String pianoStudi(int studentID){
		Studente s = studenti.get(studentID);
		Collection<Corso> subscribed = s.getCourses();
		String toRet = "";
		
		for(Corso c : subscribed)
			toRet += c.toString()+"\n";
		
		return toRet;
	}
	
	public String toString() {
		return "University: "+universityName+"\nRector: "+getRettore();
	}

}
