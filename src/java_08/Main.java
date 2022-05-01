package java_08;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		StudentRepository studentRepository = new StudentRepository();
		ArrayList<Student> students = studentRepository.findAll();
		students.forEach(student -> {
			System.out.println("Id: " + student.getId() + " Emri: " + student.getName() + " Mosha: " + 
		student.getMosha() + " StudentId: " + student.getStudentId());
		});
		
		
	}
}