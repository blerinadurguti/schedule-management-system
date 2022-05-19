package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlViewStudentet {

	private String emri,mbiemri,studentId,drejtimi,viti,grupi,nengrupi;

	public static SqlViewStudentet fromResultSet(ResultSet res) {
		
		try {
			
			String emri = res.getString("Emri");
			String mbiemri = res.getString("Mbiemri");
			String studentId = res.getString("StudentId");
			String drejtimi = res.getString("Drejtimi");
			String viti = res.getString("Viti");
			String grupi = res.getString("Grupi");
			String nengrupi = res.getString("NenGrupi");
			return new SqlViewStudentet(emri,mbiemri,studentId,drejtimi,viti,grupi,nengrupi);
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static SqlViewStudentet createSqlViewStudentet(String emri, String mbiemri, String studentId, String drejtimi, String viti, String grupi,
			String nengrupi) {
		return new SqlViewStudentet(emri,mbiemri,studentId,drejtimi,viti,grupi,nengrupi);
	}
	
	public SqlViewStudentet(String emri, String mbiemri, String studentId, String drejtimi, String viti, String grupi,
			String nengrupi) {
		this.emri = emri;
		this.mbiemri = mbiemri;
		this.studentId = studentId;
		this.drejtimi = drejtimi;
		this.viti = viti;
		this.grupi = grupi;
		this.nengrupi = nengrupi;
	}

	public String getEmri() {
		return emri;
	}

	public void setEmri(String emri) {
		this.emri = emri;
	}

	public String getMbiemri() {
		return mbiemri;
	}

	public void setMbiemri(String mbiemri) {
		this.mbiemri = mbiemri;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getDrejtimi() {
		return drejtimi;
	}

	public void setDrejtimi(String drejtimi) {
		this.drejtimi = drejtimi;
	}

	public String getViti() {
		return viti;
	}

	public void setViti(String viti) {
		this.viti = viti;
	}

	public String getGrupi() {
		return grupi;
	}

	public void setGrupi(String grupi) {
		this.grupi = grupi;
	}

	public String getNengrupi() {
		return nengrupi;
	}

	public void setNengrupi(String nengrupi) {
		this.nengrupi = nengrupi;
	}
	
	
	
}
