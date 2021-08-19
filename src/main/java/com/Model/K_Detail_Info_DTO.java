package com.Model;

public class K_Detail_Info_DTO {
	
	private int numbering = 0;  // ������ȣ
	private int k_salinity = 0;   // ����
	private int k_indoor_temp = 0;  // �ǳ��µ�
	private int k_indoor_humid = 0;	// �ǳ�����
	private int k_water_temp = 0;   // �ұݹ� �µ�
	private int k_wire_temp = 0;    // �ٴڿ����µ�
	private int k_water_high = 0;   //��������
	private int k_daily_prod = 0;   //���ϻ��귮
	private String k_harvest  = null;  // �����Ȯ���ɽñ�
	private int k_place_size = 0;     // ����ũ��
	private int k_automode = 0;       // �ڵ�/����
	private int node = 0;              // ���
	
	
	
	public K_Detail_Info_DTO(int numbering) {
		this.numbering = numbering;
	}

	public K_Detail_Info_DTO(int numbering, int k_salinity, int k_indoor_temp, int k_indoor_humid, int k_water_temp,
			int k_wire_temp, int k_water_high, int k_daily_prod, String k_harvest, int k_place_size, int k_automode,
			int node) {
		this.numbering = numbering;
		this.k_salinity = k_salinity;
		this.k_indoor_temp = k_indoor_temp;
		this.k_indoor_humid = k_indoor_humid;
		this.k_water_temp = k_water_temp;
		this.k_wire_temp = k_wire_temp;
		this.k_water_high = k_water_high;
		this.k_daily_prod = k_daily_prod;
		this.k_harvest = k_harvest;
		this.k_place_size = k_place_size;
		this.k_automode = k_automode;
		this.node = node;
	}

	public int getNumbering() {
		return numbering;
	}

	public void setNumbering(int numbering) {
		this.numbering = numbering;
	}

	public int getK_salinity() {
		return k_salinity;
	}

	public void setK_salinity(int k_salinity) {
		this.k_salinity = k_salinity;
	}

	public int getK_indoor_temp() {
		return k_indoor_temp;
	}

	public void setK_indoor_temp(int k_indoor_temp) {
		this.k_indoor_temp = k_indoor_temp;
	}

	public int getK_indoor_humid() {
		return k_indoor_humid;
	}

	public void setK_indoor_humid(int k_indoor_humid) {
		this.k_indoor_humid = k_indoor_humid;
	}

	public int getK_water_temp() {
		return k_water_temp;
	}

	public void setK_water_temp(int k_water_temp) {
		this.k_water_temp = k_water_temp;
	}

	public int getK_wire_temp() {
		return k_wire_temp;
	}

	public void setK_wire_temp(int k_wire_temp) {
		this.k_wire_temp = k_wire_temp;
	}

	public int getK_water_high() {
		return k_water_high;
	}

	public void setK_water_high(int k_water_high) {
		this.k_water_high = k_water_high;
	}

	public int getK_daily_prod() {
		return k_daily_prod;
	}

	public void setK_daily_prod(int k_daily_prod) {
		this.k_daily_prod = k_daily_prod;
	}

	public String getK_harvest() {
		return k_harvest;
	}

	public void setK_harvest(String k_harvest) {
		this.k_harvest = k_harvest;
	}

	public int getK_place_size() {
		return k_place_size;
	}

	public void setK_place_size(int k_place_size) {
		this.k_place_size = k_place_size;
	}

	public int getK_automode() {
		return k_automode;
	}

	public void setK_automode(int k_automode) {
		this.k_automode = k_automode;
	}

	public int getNode() {
		return node;
	}

	public void setNode(int node) {
		this.node = node;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
