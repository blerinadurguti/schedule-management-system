package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AssignedSubjectDrejtimi{
	private int id;
	private int DrejtimiId;
	private int VitiAkademikId;
	
	public static AssignedSubjectDrejtimi fromResultSet(ResultSet res) {
		try {
			int id = res.getInt("Id");
			int DrejtimiId = res.getInt("DrejtimiId");
			int VitiAkademikId = res.getInt("VitiAkademikId");
			return new AssignedSubjectDrejtimi(id,DrejtimiId, VitiAkademikId);
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static AssignedSubjectDrejtimi createAssignedSubjectDrejtimi(
			int id, int DrejtimiId, int VitiAkademikId
			) {
		return new AssignedSubjectDrejtimi(id, DrejtimiId, VitiAkademikId);
	}
	
	private AssignedSubjectDrejtimi(int id, int DrejtimiId, int VitiAkademikId) {
		this.id = id;
		this.DrejtimiId = DrejtimiId;
		this.VitiAkademikId = VitiAkademikId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getDrejtimiId() {
		return DrejtimiId;
	}


	public void setDrejtimiId(int DrejtimiId) {
		this.DrejtimiId = DrejtimiId;
	}
	
	public int getVitiAkademikId() {
		return VitiAkademikId;
	}


	public void setVitiAkademikId(int VitiAkademikId) {
		this.VitiAkademikId = VitiAkademikId;
	}
	
}
