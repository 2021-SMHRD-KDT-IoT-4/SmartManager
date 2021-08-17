package com.Model;

public class OutPut_DTO {
	private int numbering;
	private String date_search;
	private int prod;
	public OutPut_DTO(int numbering, String date_search, int prod) {
		this.numbering = numbering;
		this.date_search = date_search;
		this.prod = prod;
	}
	public OutPut_DTO(int numbering) {
		this.numbering = numbering;
	}
	
	public int getNumbering() {
		return numbering;
	}
	public void setNumbering(int numbering) {
		this.numbering = numbering;
	}
	public String getDate_search() {
		return date_search;
	}
	public void setDate_search(String date_search) {
		this.date_search = date_search;
	}
	public int getProd() {
		return prod;
	}
	public void setProd(int prod) {
		this.prod = prod;
	}
	
	
	
	
}