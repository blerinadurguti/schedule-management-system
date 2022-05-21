package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import model.Oraret;
import model.Studenti;

public class OraretRepository {

	private DBConnection connection;
	private CarryRepository carryRepository = new CarryRepository();
	private GrupiRepository grupiRepository = new GrupiRepository();
	private DrejtimiRepository drejtimiRepository = new DrejtimiRepository();
	private VitiAkademikRepository vitiAkademikRepository = new VitiAkademikRepository();
	private StudentRepository studentRepository = new StudentRepository();
	private StafiAkademikRepository stafiAkademikRepository = new StafiAkademikRepository();
	private String grupi = "";
	private String profa = "";
	private String viti = "";
	private String drejtimi = "";
	
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
	
	public ObservableList<Oraret> getDataS() throws SQLException{
		this.setGrupi();
		this.setDrejtimi();
		this.setViti();
		
		ObservableList<Oraret> oblist = FXCollections.observableArrayList();
		String query = "select * from oraret where grupi = '" + grupi + "' and viti = '" + viti + "' and drejtimi = '" + drejtimi + "'";
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
	
	public void setDrejtimi() throws SQLException {
		this.drejtimi = drejtimiRepository.getEmriById(studentRepository.getDrejtimiById(carryRepository.getId()));
	}
	
	public void setViti() throws SQLException {
		this.viti = vitiAkademikRepository.getEmriById(studentRepository.getVitiById(carryRepository.getId()));
	}
	
	public void setProfa() throws SQLException {
		this.profa = stafiAkademikRepository.getProfaById(carryRepository.getId());
	}
	
	public boolean checkOrariTaken(ChoiceBox<String> Cdrejtimi,ChoiceBox<String> Cviti,
			ChoiceBox<String> Cgrupi,ChoiceBox<String> Csalla,
			ChoiceBox<String> Cdita ,ChoiceBox<String> Ckoha) throws SQLException 
	{
		String drejtimi = Cdrejtimi.getValue();
		String viti = Cviti.getValue();
		String grupi = Cgrupi.getValue();
		String salla = Csalla.getValue();
		String dita = Cdita.getValue();
		String koha = Ckoha.getValue();
				
		String query = "CALL checkIfExists('" + drejtimi +"','" + viti + 
											"','" + grupi + "','" + salla + 
											"','" + dita + "','" + koha + "')";
		
		this.connection.ExecuteOraret(query);
		
		if(carryRepository.getIdOraret().equals("0")) {
			return true;
		}else {
			return false;
		}
	}
	
	public void insertOrari(ChoiceBox<String> Cdrejtimi,ChoiceBox<String> Cviti,
			ChoiceBox<String> Cgrupi,ChoiceBox<String> CLenda,
			ChoiceBox<String> Clu, ChoiceBox<String> Csalla,
			ChoiceBox<String> Cdita ,ChoiceBox<String> Ckoha) throws SQLException {
		String drejtimi = Cdrejtimi.getValue();
		String viti = Cviti.getValue();
		String grupi = Cgrupi.getValue();
		String lenda = CLenda.getValue();
		String LU = Clu.getValue();
		String salla = Csalla.getValue();
		String dita = Cdita.getValue();
		String koha = Ckoha.getValue();
		
		String profesori = stafiAkademikRepository.getProfaById(carryRepository.getId());
		
		//insert into Oraret(l_u,drejtimi,lenda,profesori,viti,grupi,salla,dita,KohaFillimit)
		//values("Ligjerat","Automatikë e Kompjuterizuar dhe Robotikë","Gjuhe Angleze","Gazmend Pula"
		//,"Viti 1","Grupi 1A","A408","E hëne","09")
		
		String query = "Insert into oraret(l_u,drejtimi,lenda,profesori,viti,grupi,salla,dita,KohaFillimit) values "
				+ "('" + LU + "','" + drejtimi + "','" + lenda + "','" + profesori + "','" + viti + "','"+ grupi +
				"','"+ salla +"','"+ dita +"','"+ koha +"')";
		
		this.connection.executeU(query);
		
	}
	
}
