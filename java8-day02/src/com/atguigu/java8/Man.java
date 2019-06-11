package com.atguigu.java8;

public class Man {

	private Woman goddess;

	public Man() {
	}

	public Man(Woman goddess) {
		this.goddess = goddess;
	}

	public Woman getGoddess() {
		return goddess;
	}

	public void setGoddess(Woman goddess) {
		this.goddess = goddess;
	}

}
