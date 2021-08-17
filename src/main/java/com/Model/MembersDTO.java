package com.Model;

public class MembersDTO {

	private String id;
	private String pw;
	private int idseq; // 시퀀스 번호
	
	
	
	
	public MembersDTO(String id, String pw, int idseq) {
		super();
		this.id = id;
		this.pw = pw;
		this.idseq = idseq;
	}
	
	
	
	public MembersDTO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getIdseq() {
		return idseq;
	}
	public void setIdseq(int idseq) {
		this.idseq = idseq;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
