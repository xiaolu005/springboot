package com.atguigu.java8;

public class FilterAgeEmployeePre implements Predicate<Employee>{

	@Override
	public boolean test(Employee t) {
		return t.getAge() <= 35;
	}

}
