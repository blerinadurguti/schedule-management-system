package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StafiAkademik {

	private int id;
	private String emri;
	private String mbiemri;
	private String pozita;
	
	public static StafiAkademik fromResultSet(ResultSet res) {
		try {
			int id = res.getInt("Id");
			String emri = res.getString("Emri");
			String mbiemri = res.getString("Mbiemri");
			String pozita = res.getString("Pozita");
			return new StafiAkademik(id,emri,mbiemri,pozita);
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static StafiAkademik createStafiAkademik(
			int id, String emri, String mbiemri, String pozita
			) {
		return new StafiAkademik(id,emri,mbiemri,pozita);
	}
	
	public StafiAkademik(int id, String emri, String mbiemri, String pozita) {
		this.id = id;
		this.emri = emri;
		this.mbiemri = mbiemri;
		this.pozita = pozita;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public String getPozita() {
		return pozita;
	}

	public void setPozita(String pozita) {
		this.pozita = pozita;
	}
	

}
