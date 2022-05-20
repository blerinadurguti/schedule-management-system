package application;

import java.sql.SQLException;

import model.Studenti;
import repository.CarryRepository;
import repository.GrupiRepository;
import repository.OraretRepository;
import repository.StudentRepository;
import repository.UserRepository;

public class CarryTest {

	public static void main(String[] args) throws SQLException {
		
		GrupiRepository grupiRepository = new GrupiRepository();
		OraretRepository oraretRepository = new OraretRepository();
		
		oraretRepository.setGrupi();
	}
	
}
