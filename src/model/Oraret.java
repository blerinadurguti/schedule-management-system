package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Oraret {

	private int id;
	private String l_u,drejtimi, lenda, profesori,viti, grupi, salla, dita, kohaFillimit;
	
	public static Oraret fromResultSet(ResultSet res) {

		try {
		int id = res.getInt("Id");
		String drejtimi = res.getString("drejtimi");
		String l_u = res.getString("l_u");
		String lenda = res.getString("lenda");
		String profesori = res.getString("profesori");
		String grupi = res.getString("grupi");
		String viti = res.getString("viti");
		String salla = res.getString("salla");
		String dita = res.getString("dita");
		String kohaFillimit = res.getString("KohaFillimit");
		 	return new Oraret(id,drejtimi,l_u,lenda,profesori,viti,grupi,salla,dita,kohaFillimit);
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Oraret createOraret(int id,String drejtimi, String l_u, String lenda, String profesori, String viti, String grupi, String salla, String dita, String kohaFillimit) {
		return new Oraret(id,drejtimi,l_u,lenda,profesori,viti,grupi,salla,dita,kohaFillimit);
	}
	
	public Oraret(int id,String drejtimi, String l_u, String lenda, String profesori,String viti,String grupi, String salla, String dita, String kohaFillimit) {
		this.id = id;
		this.drejtimi = drejtimi;
		this.l_u = l_u;
		this.lenda = lenda;
		this.grupi = grupi;
		this.viti = viti;
		this.profesori = profesori;
		this.salla = salla;
		this.dita = dita;
		this.kohaFillimit = kohaFillimit;
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

	public String getGrupi() {
		return grupi;
	}

	public void setGrupi(String grupi) {
		this.grupi = grupi;
	}

	public String getL_u() {
		return l_u;
	}

	public void setL_u(String l_u) {
		this.l_u = l_u;
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
	
	

}