package application;

import java.sql.SQLException;

import database.DBConnection;
import javafx.scene.control.ChoiceBox;
import model.Studenti;
import processor.GjuhaProcessor;
import repository.CarryRepository;
import repository.GrupiRepository;
import repository.LendetRepository;
import repository.OraretRepository;
import repository.StafiAkademikRepository;
import repository.StudentRepository;
import repository.UserRepository;

public class CarryTest {

	public static void main(String[] args) throws SQLException {
		
		GrupiRepository grupiRepository = new GrupiRepository();
		OraretRepository oraretRepository = new OraretRepository();
		LendetRepository lendetRepository = new LendetRepository();
		DBConnection connection = DBConnection.getConnection();
		StafiAkademikRepository stafiAkademikRepository = new StafiAkademikRepository();
		CarryRepository carryRepository = new CarryRepository();
		
//		String query = "Select * from carry where id = 2";
//		String query2 = "Select * from oraret where drejtimi = 'Inxhinieri Kompjuterike' and viti = 'Viti 2' and grupi = 'Grupi 1b' and salla = 'A411' and dita = 'E Hene' and KohaFillimit = '16'";
//		
//		
//		if(connection.ExecuteOraret(query2)) {
//			System.out.println("Zbrazur");
//		}else {
//			System.out.println("Mbushur");
//		}
	
//		ChoiceBox<String> a = new ChoiceBox<String>();
//		a.setValue("Taken");
//		System.out.println(a.getValue());
	
//		String profesori = stafiAkademikRepository.getProfaById(carryRepository.getId());
//		
//		System.out.println(profesori);
	
		GjuhaProcessor g = new GjuhaProcessor();
		
		System.out.println(g.setGjuha());
	}
	
}
