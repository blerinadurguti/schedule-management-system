package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AssignedSubjectTeacher{
	private int id;
	private int LendetId;
	private int StafiAkademikIdProfesori;
	private int StafiAkademikIdAsistenti;
	private int SallaId;
	
	public static AssignedSubjectTeacher fromResultSet(ResultSet res) {
		try {
			int id = res.getInt("Id");
			int LendetId = res.getInt("LendetId");
			int StafiAkademikIdProfesori = res.getInt("StafiAkademikIdProfesori");
			int StafiAkademikIdAsistenti = res.getInt("StafiAkademikIdAsistenti");
			int SallaId = res.getInt("SallaId");
			
			return new AssignedSubjectTeacher(id, LendetId, StafiAkademikIdProfesori, StafiAkademikIdAsistenti, SallaId);
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static AssignedSubjectTeacher createAssignedSubjectTeacher(
			int id, int LendetId, int StafiAkademikIdProfesori, int StafiAkademikIdAsistenti, int SallaId
			) {
		return new AssignedSubjectTeacher(id, LendetId, StafiAkademikIdProfesori, StafiAkademikIdAsistenti, SallaId);
	}
	
	private AssignedSubjectTeacher(int id, int LendetId, int StafiAkademikIdProfesori, int StafiAkademikIdAsistenti,int SallaId) {
		this.id = id;
		this.LendetId = LendetId;
		this.StafiAkademikIdProfesori = StafiAkademikIdProfesori;
		this.StafiAkademikIdAsistenti = StafiAkademikIdAsistenti;
		this.SallaId = SallaId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getLendetId() {
		return LendetId;
	}


	public void setLendetId(int LendetId) {
		this.LendetId = LendetId;
	}
	
	public int getStafiAkademikIdProfesori() {
		return StafiAkademikIdProfesori;
	}


	public void setStafiAkademikIdProfesori(int StafiAkademikIdProfesori) {
		this.StafiAkademikIdProfesori = StafiAkademikIdProfesori;
	}
	
	public int getStafiAkademikIdAsistenti() {
		return StafiAkademikIdAsistenti;
	}


	public void setStafiAkademikIdAsistenti(int StafiAkademikIdAsistenti) {
		this.StafiAkademikIdAsistenti = StafiAkademikIdAsistenti;
	}
	
	public int getSallaId() {
		return SallaId;
	}


	public void setSallaId(int SallaId) {
		this.SallaId = SallaId;
	}
	
}
