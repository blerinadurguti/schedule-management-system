package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Oraret {

	private int id;
	private String lenda, profesori, grupi, salla, dita, kohaFillimit, kohaMbarimit;
	
	public static Oraret fromResultSet(ResultSet res) {

		try {
		int id = res.getInt("Id");
		String lenda = res.getString("lenda");
		String profesori = res.getString("profesori");
		String grupi = res.getString("grupi");
		String salla = res.getString("salla");
		String dita = res.getString("dita");
		String kohaFillimit = res.getString("KohaFillimit");
		String kohaMbarimit = res.getString("KohaPerfundimit");
		 	return new Oraret(id,lenda,profesori,grupi,salla,dita,kohaFillimit,kohaMbarimit);
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Oraret createOraret(int id, String lenda, String profesori, String grupi, String salla, String dita, String kohaFillimit,
			String kohaMbarimit) {
		return new Oraret(id,lenda,profesori,grupi,salla,dita,kohaFillimit,kohaMbarimit);
	}
	
	public Oraret(int id, String lenda, String profesori,String grupi, String salla, String dita, String kohaFillimit,
			String kohaMbarimit) {
		this.id = id;
		this.lenda = lenda;
		this.grupi = grupi;
		this.profesori = profesori;
		this.salla = salla;
		this.dita = dita;
		this.kohaFillimit = kohaFillimit;
		this.kohaMbarimit = kohaMbarimit;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLenda() {
		return lenda;
	}


	public void setLenda(String lenda) {
		this.lenda = lenda;
	}


	public String getProfesori() {
		return profesori;
	}


	public void setProfesori(String profesori) {
		this.profesori = profesori;
	}


	public String getSalla() {
		return salla;
	}


	public void setSalla(String salla) {
		this.salla = salla;
	}


	public String getDita() {
		return dita;
	}


	public void setDita(String dita) {
		this.dita = dita;
	}


	public String getKohaFillimit() {
		return kohaFillimit;
	}


	public void setKohaFillimit(String kohaFillimit) {
		this.kohaFillimit = kohaFillimit;
	}


	public String getKohaMbarimit() {
		return kohaMbarimit;
	}


	public void setKohaMbarimit(String kohaMbarimit) {
		this.kohaMbarimit = kohaMbarimit;
	}

	public String getGrupi() {
		return grupi;
	}

	public void setGrupi(String grupi) {
		this.grupi = grupi;
	}
	
	

}