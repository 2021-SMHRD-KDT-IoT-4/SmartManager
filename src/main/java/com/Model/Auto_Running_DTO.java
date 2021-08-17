package com.Model;

public class Auto_Running_DTO {

	private int numbering;
	private int fan_run;
	private int pump_run;
	private int wire_run;
	private int light_run;
	
	public Auto_Running_DTO(int numbering, int fan_run, int pump_run, int wire_run, int light_run) {
		this.numbering = numbering;
		this.fan_run = fan_run;
		this.pump_run = pump_run;
		this.wire_run = wire_run;
		this.light_run = light_run;
	}
	
	public Auto_Running_DTO(int numbering) {
		this.numbering = numbering;
	
	}
	

	public int getNumbering() {
		return numbering;
	}

	public void setNumbering(int numbering) {
		this.numbering = numbering;
	}

	public int getFan_run() {
		return fan_run;
	}

	public void setFan_run(int fan_run) {
		this.fan_run = fan_run;
	}

	public int getPump_run() {
		return pump_run;
	}

	public void setPump_run(int pump_run) {
		this.pump_run = pump_run;
	}

	public int getWire_run() {
		return wire_run;
	}

	public void setWire_run(int wire_run) {
		this.wire_run = wire_run;
	}

	public int getLight_run() {
		return light_run;
	}

	public void setLight_run(int light_run) {
		this.light_run = light_run;
	}
	
}