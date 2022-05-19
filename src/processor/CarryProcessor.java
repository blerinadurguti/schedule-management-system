package processor;

import java.sql.SQLException;

import javafx.scene.control.Label;
import model.StafiAkademik;
import model.Studenti;
import repository.CarryRepository;
import repository.DrejtimiRepository;
import repository.GrupiRepository;
import repository.StafiAkademikRepository;
import repository.StudentRepository;
import repository.VitiAkademikRepository;

public class CarryProcessor {

	private CarryRepository c = new CarryRepository();
	private StudentRepository s = new StudentRepository();
	private StafiAkademikRepository p = new StafiAkademikRepository();
	private Studenti student;
	private StafiAkademik staf;
	
	public CarryProcessor() throws SQLException {
		student = this.getStudent();
		staf = this.getStafiAkademik();
	}
	
	private Studenti getStudent() throws SQLException {
		
	 Studenti a = s.findById2(c.getId());	
		
		return a;
	}
	
	private StafiAkademik getStafiAkademik() throws SQLException {
	
		StafiAkademik b = p.findById2(c.getId());
		
		return b;
	}
	
	
	public void SetDashboardStudenti(Label l) {
		l.setText(student.getEmri() + " " + student.getMbiemri());
	}
	
	public void SetDashboardStafi(Label l) {
		l.setText(staf.getEmri() + " " + staf.getMbiemri());
	}
	
	public void SetProfiliStudent(Label a1,Label a2,Label a3,Label a4,Label a5,Label a6,Label a7) throws SQLException {
	
		VitiAkademikRepository viti = new VitiAkademikRepository();
		DrejtimiRepository drejtimi = new DrejtimiRepository();
		GrupiRepository grupi = new GrupiRepository();
		
		a1.setText(student.getEmri() + " " + student.getMbiemri());
		a2.setText(student.getEmri());
		a3.setText(student.getMbiemri());
		a4.setText(student.getStudentId());
		a6.setText(viti.getEmriById(student.getViti()));
		a5.setText(drejtimi.getEmriById(student.getDrejtimi()));
		a7.setText(grupi.getEmriById(student.getGrupi()));
	}
	
	public void SetOrariStudenti(Label a) {
		a.setText(student.getEmri() + " " + student.getMbiemri());
	}
	
	public void SetProfiliStaf(Label a1, Label a2, Label a3, Label a4) {
		a1.setText(staf.getEmri() + " " + staf.getMbiemri());
		a2.setText(staf.getEmri());
		a3.setText(staf.getMbiemri());
		a4.setText(staf.getPozita());
	}
	
	public void SetOrariStaf(Label a) {
		a.setText(staf.getEmri() + " " + staf.getMbiemri());
	}

	public void SetShtoLigjeraten(Label a) {
		a.setText(staf.getEmri() + " " + staf.getMbiemri());
	}
	
	public void setStudentiNdrysho(Label a) {
		a.setText(student.getEmri() + " " + student.getMbiemri());
	}
	
	public void setStafNdrysho(Label a) {
		a.setText(staf.getEmri() + " " + staf.getMbiemri());
	}
	
}
