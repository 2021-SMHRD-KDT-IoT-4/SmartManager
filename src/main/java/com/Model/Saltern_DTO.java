package com.Model;

public class Saltern_DTO {
	
	private int numbering;  // ¿°Àü¹øÈ£
	private String member_id; // id 
	private int part;
	
	public Saltern_DTO(int numbering, String member_id, int part) {
		super();
		this.numbering = numbering;
		this.member_id = member_id;
		this.part = part;
	}
	
	
	
	public Saltern_DTO(String member_id, int part) {
		this.member_id = member_id;
		this.part = part;
	}



	public int getNumbering() {
		return numbering;
	}
	public void setNumbering(int numbering) {
		this.numbering = numbering;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getPart() {
		return part;
	}
	public void setPart(int part) {
		this.part = part;
	}

	
	
	
}
