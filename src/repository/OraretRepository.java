package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Oraret;
import model.Studenti;

public class OraretRepository {

	private DBConnection connection;
	private CarryRepository carryRepository = new CarryRepository();
	private GrupiRepository grupiRepository = new GrupiRepository();
	private StudentRepository studentRepository = new StudentRepository();
	private StafiAkademikRepository stafiAkademikRepository = new StafiAkademikRepository();
	private String grupi;
	private String profa;
	
	public OraretRepository() {
		this.connection = DBConnection.getConnection();
	}
	
	public ObservableList<Oraret> getData() throws SQLException{
		ObservableList<Oraret> oblist = FXCollections.observableArrayList();
		String query = "select * from oraret";
		ResultSet res = connection.executeQuery(query);
		
		while(res.next()) {
			oblist.add(Oraret.fromResultSet(res));
		}
		return oblist;
	}
	
	public ObservableList<Oraret> getDataG() throws SQLException{
		this.setGrupi();
		ObservableList<Oraret> oblist = FXCollections.observableArrayList();
		String query = "select * from oraret where grupi = '" + grupi + "'";
		ResultSet res = connection.executeQuery(query);
		
		while(res.next()) {
			oblist.add(Oraret.fromResultSet(res));
		}
		return oblist;
	}
	
	public ObservableList<Oraret> getDataP() throws SQLException{
		this.setProfa();
		ObservableList<Oraret> oblist = FXCollections.observableArrayList();
		String query = "select * from oraret where profesori = '" + profa + "'";
		ResultSet res = connection.executeQuery(query);
		
		while(res.next()) {
			oblist.add(Oraret.fromResultSet(res));
		}
		return oblist;
	}
	
	public void setGrupi() throws SQLException {
		this.grupi = grupiRepository.getEmriById(studentRepository.getGrupiById(carryRepository.getId()));
	}
	
	public void setProfa() throws SQLException {
		this.profa = stafiAkademikRepository.getProfaById(carryRepository.getId());
	}
	
}
