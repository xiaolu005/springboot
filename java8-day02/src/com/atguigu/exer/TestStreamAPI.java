package com.atguigu.exer;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.atguigu.exer.Employee.Status;


public class TestStreamAPI {
	
	/*
	1.	给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
	例如，给定【1，2，3，4，5】， 应该返回【1，4，9，16，25】。
	 */
	@Test
	public void test1(){
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		list.stream()
			.map((x) -> x * x)
			.forEach(System.out::println);
	}
	
	
	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99, Status.FREE), 
			new Employee(102, "李四", 22, 6666.99, Status.BUSY),
			new Employee(103, "王五", 58, 3333.99, Status.VOCATION), 
			new Employee(104, "赵六", 28, 5555.99, Status.BUSY),
			new Employee(105, "田七", 16, 1111.99, Status.BUSY),
			new Employee(105, "田七", 16, 1111.99, Status.BUSY));
	
	@Test
	public void test2(){
		Integer count = emps.stream()
			.map((x) -> x.getId())
			.reduce(0, (x, y) -> x + 1);
		
		System.out.println(count);
		
		Long count1 = emps.stream()
			.count();
		
		System.out.println(count1);
	}

}
