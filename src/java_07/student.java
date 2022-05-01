package java_07;



public class student {
private int Id;
private String emri;
private String studentId;
private String mbiemri;

public static student fromResultSet(ResultSet res) {
	
	try {
	int Id = res.getInt("Id");
	String emri = res.getString("emri");
	String mbiemri = res.getString("mbiemri");
	String studentUd = res.getString("studentId");
	}catch(SQLException e) {
		
	}
	
}

private student(int id, String emri, String mbiemri, String studentId) {
	super();
	this.Id = id;
	this.emri = emri;
	this.studentId = studentId;
	this.mbiemri = mbiemri;
}

public int getId() {
	return Id;
}

public void setId(int id) {
	Id = id;
}

public String getEmri() {
	return emri;
}

public void setEmri(String emri) {
	this.emri = emri;
}

public String getStudentId() {
	return studentId;
}

public void setStudentId(String studentId) {
	this.studentId = studentId;
}

public String getMbiemri() {
	return mbiemri;
}

public void setMbiemri(String mbiemri) {
	this.mbiemri = mbiemri;
}


}
