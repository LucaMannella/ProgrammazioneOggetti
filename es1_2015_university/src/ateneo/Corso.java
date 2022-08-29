package ateneo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Corso implements Comparable<Corso>{

	private static final int MAX_STUDENTS = 100;
	
	private int courseID;
	private String subject;
	private String teacher;
	private Map<Integer, Studente> studenti;
	
	public Corso(int courseID, String subject, String teacher) {
		this.courseID = courseID;
		this.subject = subject;
		this.teacher = teacher;
		
		this.studenti = new HashMap<Integer, Studente>();
	}
	
	public String toString() {
		return courseID+" - "+subject+" - "+teacher;
	}

	@Override
	public boolean equals(Object o) {
		Corso other = (Corso) o;
		
		if( this.courseID != other.getCourseID() )
			return false;
		if(!this.subject.equals(other.getSubject()))
			return false;
		if(!this.teacher.equals(other.getTeacher()))
			return false;
		
		return true;
	}

	@Override
	public int compareTo(Corso other) {
		int toRet = this.subject.compareTo(other.getSubject());
		
		if(toRet == 0) {
			toRet = this.teacher.compareTo(other.getTeacher());
			if(toRet == 0) {
				toRet = this.courseID - other.getCourseID();
			}
		}
		return toRet;
	}
	
	/** This method enrolls a students in the course.
	 * @return - False if the MAX number of students was reached, True otherwise.
	 */
	public boolean addStudent(Studente s) {
		if(studenti.size() >= MAX_STUDENTS)
			return false;
		
		studenti.put(s.getStudentID(), s);
		return true;
	}
	
	public void removeStudent(int studentID) {
		studenti.remove(studentID);
	}

/** This method changes the course's teacher and it returns the name of the previous teacher. **/
	public String changeTeacher(String teacher) {
		String previous = this.teacher;
		this.teacher = teacher;
		return previous;
	}

	/* -.-.-.-.-.- Getter and Setter Methods -.-.-.-.-.- */
	public int getCourseID() {
		return courseID;
	}

	public String getSubject() {
		return subject;
	}

	public String getTeacher() {
		return teacher;
	}
	
	public Collection<Studente> getStudents() {
		return studenti.values();
		
	}
}
