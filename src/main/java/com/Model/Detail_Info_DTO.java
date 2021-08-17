package com.Model;

public class Detail_Info_DTO {
	
	private int numbering = 0;  // 염전번호
	private int salinity = 0;   // 염도
	private int indoor_temp = 0;  // 실내온
	private int indoor_humid = 0;
	private int water_temp = 0;   // 소금물 온도
	private int wire_temp = 0;    // 바닥열선온도
	private int water_high = 0;   //수위정보
	private int daily_prod = 0;   //일일생산량
	private String harvest  = null;  // 예상수확가능시기
	private int place_size = 0;     // 염전크기
	private String automode = null;       // 자동/수동
	private String supplyinfo = null;    // 작업 상태 
	
	
	
	
	
	public Detail_Info_DTO(int numbering) {
		this.numbering = numbering;
	}





	public Detail_Info_DTO(int numbering, int salinity, int indoor_temp, int indoor_humid, int water_temp,
			int wire_temp, int water_high, int daily_prod, String harvest, int place_size, String automode,
			String supplyinfo) {
		this.numbering = numbering;
		this.salinity = salinity;
		this.indoor_temp = indoor_temp;
		this.indoor_humid = indoor_humid;
		this.water_temp = water_temp;
		this.wire_temp = wire_temp;
		this.water_high = water_high;
		this.daily_prod = daily_prod;
		this.harvest = harvest;
		this.place_size = place_size;
		this.automode = automode;
		this.supplyinfo = supplyinfo;
	}





	public int getNumbering() {
		return numbering;
	}





	public void setNumbering(int numbering) {
		this.numbering = numbering;
	}





	public int getSalinity() {
		return salinity;
	}





	public void setSalinity(int salinity) {
		this.salinity = salinity;
	}





	public int getIndoor_temp() {
		return indoor_temp;
	}





	public void setIndoor_temp(int indoor_temp) {
		this.indoor_temp = indoor_temp;
	}





	public int getIndoor_humid() {
		return indoor_humid;
	}





	public void setIndoor_humid(int indoor_humid) {
		this.indoor_humid = indoor_humid;
	}





	public int getWater_temp() {
		return water_temp;
	}





	public void setWater_temp(int water_temp) {
		this.water_temp = water_temp;
	}





	public int getWire_temp() {
		return wire_temp;
	}





	public void setWire_temp(int wire_temp) {
		this.wire_temp = wire_temp;
	}





	public int getWater_high() {
		return water_high;
	}





	public void setWater_high(int water_high) {
		this.water_high = water_high;
	}





	public int getDaily_prod() {
		return daily_prod;
	}





	public void setDaily_prod(int daily_prod) {
		this.daily_prod = daily_prod;
	}





	public String getHarvest() {
		return harvest;
	}





	public void setHarvest(String harvest) {
		this.harvest = harvest;
	}





	public int getPlace_size() {
		return place_size;
	}





	public void setPlace_size(int place_size) {
		this.place_size = place_size;
	}





	public String getAutomode() {
		return automode;
	}





	public void setAutomode(String automode) {
		this.automode = automode;
	}





	public String getSupplyinfo() {
		return supplyinfo;
	}





	public void setSupplyinfo(String supplyinfo) {
		this.supplyinfo = supplyinfo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
