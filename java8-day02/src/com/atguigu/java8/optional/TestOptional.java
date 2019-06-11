package com.atguigu.java8.optional;

import java.util.Optional;

import org.junit.Test;

import com.atguigu.java8.Woman;

public class TestOptional {
	
	@Test
	public void test1(){
		Optional<Man> man = Optional.ofNullable(new Man());
		System.out.println(getGoddessName(man));
	}
	
	public String getGoddessName(Optional<Man> man){
		return man.orElse(new Man(Optional.of(new Woman("苍老师"))))
				  .getGoddess()
				  .orElse(new Woman("苍老师"))
				  .getName();
	}

}
