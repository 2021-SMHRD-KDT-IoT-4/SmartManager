package com.Model;

public class ControlDTO {
	
	
	private int numbering; // ������ȣ
	private int fan;   // ȯǳ����
	private int pump;  // ��������
	private int wire;  // �ٴڿ�������
	private int pusher;// �д�����
	private int conveyer;// �����̾� ����
	private int light; // ��������
	private int camera; // CCTV����
	
	
	
	


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
