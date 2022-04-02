package model;

public class Student {
	private int id;
	private String emri;
	private String mbiemri;
	private String studentId;
	private int mosha;
	public Student(int id, String emri, String mbiemri, String studentId, int mosha) {
		super();
		this.id = id;
		this.emri = emri;
		this.mbiemri = mbiemri;
		this.studentId = studentId;
		this.mosha = mosha;
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
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public int getMosha() {
		return mosha;
	}
	public void setMosha(int mosha) {
		this.mosha = mosha;
	}
	

}