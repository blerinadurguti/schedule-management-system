package java_07;

import java.util.ArrayList;

public class Main {

		StudentRepository studentRepository = new StudentRepository();
		ArrayList<student> students = studentRepository.findAll();
		
		students.forEach(s->{
			System.out.println("ID:"+s.getId());
			System.out.println("studentId:"+s.getstudentId());
		})

}
