package com.atguigu.java8.optional;

import java.util.Optional;

import com.atguigu.java8.Woman;

public class Man {

	private Optional<Woman> goddess = Optional.empty(); // 可能有可能没有

	public Man() {
	}

	public Man(Optional<Woman> goddess) {
		this.goddess = goddess;
	}

	public Optional<Woman> getGoddess() {
		return goddess;
	}

	public void setGoddess(Optional<Woman> goddess) {
		this.goddess = goddess;
	}

	@Override
	public String toString() {
		return "Man [goddess=" + goddess + "]";
	}

}
