package com.Model;

public class Saltern_DTO {
	
	private int numbering = 0;  // ¿°Àü¹øÈ£
	private String member_id = null; // id 
	
	
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
	
	
	public Saltern_DTO(int numbering, String member_id) {
		
		this.numbering = numbering;
		this.member_id = member_id;
	}
	
	public Saltern_DTO(int numbering) {
		
		this.numbering = numbering;
		
	}
	
	
	
	
	
}
