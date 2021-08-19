package com.Model;

public class ControlDTO {
	
	
	private int numbering; // 염전번호
	private int fan;   // 환풍제어
	private int pump;  // 수조펌프
	private int wire;  // 바닥열선제어
	private int pusher;// 밀대제어
	private int conveyer;// 컨베이어 제어
	private int light; // 조명제어
	private int camera; // CCTV제어
	
	
	
	


	public ControlDTO(int numbering, int fan, int pump, int wire, int pusher, int conveyer, int light,
			int camera) {
		super();
		this.numbering = numbering;
		this.fan = fan;
		this.pump = pump;
		this.wire = wire;
		this.pusher = pusher;
		this.conveyer = conveyer;
		this.light = light;
		this.camera = camera;
	}

	
	
	
	

	public ControlDTO(int numbering) {
		super();
		this.numbering = numbering;
	}







	public int getNumbering() {
		return numbering;
	}



	public void setNumbering(int numbering) {
		this.numbering = numbering;
	}



	public int getFan() {
		return fan;
	}



	public void setFan(int fan) {
		this.fan = fan;
	}



	public int getPump() {
		return pump;
	}



	public void setPump(int pump) {
		this.pump = pump;
	}



	public int getWire() {
		return wire;
	}



	public void setWire(int wire) {
		this.wire = wire;
	}



	public int getPusher() {
		return pusher;
	}



	public void setPusher(int pusher) {
		this.pusher = pusher;
	}



	public int getConveyer() {
		return conveyer;
	}



	public void setConveyer(int conveyer) {
		this.conveyer = conveyer;
	}



	public int getLight() {
		return light;
	}



	public void setLight(int light) {
		this.light = light;
	}



	public int getCamera() {
		return camera;
	}



	public void setCamera(int camera) {
		this.camera = camera;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
