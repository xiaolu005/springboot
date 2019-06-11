package com.atguigu.java8;

public class FilterSalaryEmployeePre implements Predicate<Employee>{

	@Override
	public boolean test(Employee t) {
		return t.getSalary() >= 5000;
	}

}
