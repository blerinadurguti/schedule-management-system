package java_08_nga_profi;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		StudentRepository studentRepository = 
				new StudentRepository();
		
		ArrayList<Student> students = studentRepository.findAll();
		
		students.forEach(s -> {
			System.out.println("Studenti: " + s.getEmri() + " " + s.getMbiemri()
								+ " me Id: " + s.getId() + " StudentId: " + s.getStudentId()
								+ " dhe me Moshen: " + s.getMosha());
		});
		
		
		
	}

}