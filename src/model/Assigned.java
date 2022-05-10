package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Assigned{
	private int id;
	private int GrupetId;
	private int LendetId;
	private int OraretId;
	
	public static Assigned fromResultSet(ResultSet res) {
		try {
			int id = res.getInt("Id");
			int GrupetId = res.getInt("GrupetId");
			int LendetId = res.getInt("LendetId");
			int OraretId = res.getInt("OraretId");
			return new Assigned(id,GrupetId, LendetId, OraretId);
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Assigned createAssigned(
			int id, int GrupetId, int LendetId, int OraretId
			) {
		return new Assigned(id,GrupetId, LendetId, OraretId);
	}
	
	private Assigned(int id, int GrupetId, int LendetId, int OraretId) {
		this.id = id;
		this.GrupetId = GrupetId;
		this.LendetId = LendetId;
		this.OraretId = OraretId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getGrupetId() {
		return GrupetId;
	}


	public void setEmri(int GrupetId) {
		this.GrupetId = GrupetId;
	}
	
	public int getLendetId() {
		return LendetId;
	}


	public void setLendetId(int LendetId) {
		this.LendetId = LendetId;
	}
	
	public int getOraretId() {
		return OraretId;
	}


	public void setOraretId(int OraretId) {
		this.OraretId = OraretId;
	}
	
}
