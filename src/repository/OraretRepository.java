package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import model.Oraret;

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
		res.close();
		return oblist;
	}
	
	public void setFilteredData(ArrayList<Oraret> a) throws SQLException {
		
		String query1 = "Call deleteFiltered()";
		
		this.connection.executeU(query1);
		
		for(int i = 0; i < a.size();i++) {
			String query = "CALL insertFiltered('" + a.get(i).getL_u() + "','"+ a.get(i).getDrejtimi() 
												+"','"+ a.get(i).getLenda() +"','"+ a.get(i).getProfesori()
												+"','"+ a.get(i).getViti() +"','"+ a.get(i).getGrupi()
												+"','"+ a.get(i).getSalla() +"','"+ a.get(i).getDita()
												+"','"+ a.get(i).getKohaFillimit() +"')";
			this.connection.executeU(query);
		}
		
	}
	
	public void getFilteredData(String dita,String drejtimi,String grupi,String koha,
			String lenda, String profesori,String salla, String viti,String lu) throws SQLException{
				
		String query = "select * from oraret where dita like '%"+ dita
										+"%' and drejtimi like '%"+ drejtimi 
										+"%' and grupi like '%"+ grupi 
										+"%' and KohaFillimit like '%"+ koha
										+"%' and lenda like '%"+ lenda
										+"%' and l_u like '%"+ lu
										+"%' and profesori like '%"+ profesori
										+"%' and salla like '%"+ salla
										+"%' and viti like '%"+ viti +"%'";
		
		ArrayList<Oraret> oblist = new ArrayList<Oraret>();
		ResultSet res = connection.executeQuery(query);
		
		while(res.next()) {
			oblist.add(Oraret.fromResultSet(res));
		}
		res.close();
		setFilteredData(oblist);
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
		res.close();
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
		res.close();
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
	
	public boolean checkProfaBusy(ChoiceBox<String> Cdita ,ChoiceBox<String> Ckoha) throws SQLException {
		
		String pid = carryRepository.getId();
		String profa = stafiAkademikRepository.getProfaById(pid);
		String dita = Cdita.getValue();
		String koha = Ckoha.getValue();
		
		String query = "Call profaBusy('"+dita+"','"+koha+"','"+profa+"')";		
		this.connection.ExecuteOraret(query);
		
		if(carryRepository.getIdProfaB().equals("0")) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean checkGrupi(ChoiceBox<String> Cdita ,ChoiceBox<String> Ckoha, ChoiceBox<String> Cgrupi,ChoiceBox<String> Cdrejtimi, ChoiceBox<String> Cviti) throws SQLException{
		
		String dita = Cdita.getValue();
		String koha = Ckoha.getValue();
		String grupi = Cgrupi.getValue();
		String drejtimi = Cdrejtimi.getValue();
		String viti = Cviti.getValue();
		
		String query = "Select * from oraret where grupi = '"+grupi+"' and dita = '"+dita
				+"' and KohaFillimit = '"+koha+"' and viti = '"+viti+"' and drejtimi  = '"+drejtimi+"'";
		ResultSet res = this.connection.executeQuery(query);
		boolean b = res.next();
		res.close();
		if(b == true) {
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
				
		String query = "Insert into oraret(l_u,drejtimi,lenda,profesori,viti,grupi,salla,dita,KohaFillimit) values "
				+ "('" + LU + "','" + drejtimi + "','" + lenda + "','" + profesori + "','" + viti + "','"+ grupi +
				"','"+ salla +"','"+ dita +"','"+ koha +"')";
		
		this.connection.executeU(query);
		
	}
	
}
