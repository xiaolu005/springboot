package com.atguigu.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.atguigu.java8.Employee;
import com.atguigu.java8.Employee.Status;

public class TestStreamAPI3 {
	 

	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99, Status.FREE), 
			new Employee(102, "李四", 22, 6666.99, Status.BUSY),
			new Employee(103, "王五", 58, 3333.99, Status.VOCATION), 
			new Employee(104, "赵六", 28, 5555.99, Status.BUSY),
			new Employee(105, "田七", 16, 1111.99, Status.FREE),
			new Employee(105, "田七", 16, 1111.99, Status.BUSY));
	
	//3. 终止操作
	/*
	 	归约
		reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
	 */
	@Test
	public void test6(){
		Optional<Double> op = emps.stream()
			.map((e) -> e.getSalary())
			.reduce((x, y) -> x + y);
		
		System.out.println(op.get());
	}
	
	@Test
	public void test5(){
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		Integer sum = list.stream()
						  .reduce(0, (x, y) -> x + y);
		
		System.out.println(sum);
	}
	
	//3. 终止操作
	/*
		allMatch——检查是否匹配所有元素
		anyMatch——检查是否至少匹配一个元素
		noneMatch——检查是否没有匹配所有元素
		findFirst——返回第一个元素
		findAny——返回当前流中的任意元素
		count——返回流中元素的总个数
		max——返回流中最大值
		min——返回流中最小值
	 */
	@Test
	public void test4(){
		long count = emps.stream()
						.count();
		
		System.out.println(count);
		
		Optional<Double> max = emps.stream()
			.map((e) -> e.getSalary())
			.max(Double::compare);
		System.out.println(max.get());
	}
	
	@Test
	public void test3(){
		Optional<Employee> op = emps.stream()
			.filter((e) -> e.getStatus().equals(Status.FREE))
			.findAny();
		
		System.out.println(op.get());
	}
	
	@Test
	public void test2(){
		Optional<Double> op = emps.stream()
			.map((e) -> e.getSalary())
			.sorted(Double::compare)
			.findFirst();
		
		System.out.println(op.get());
	}
	
	@Test
	public void test1(){
		boolean flag = emps.stream()
			.allMatch((e) -> e.getStatus().equals(Status.BUSY));
		
		System.out.println(flag);
		
		flag = emps.stream()
			.anyMatch((e) -> e.getStatus().equals(Status.BUSY));
		
		System.out.println(flag);
		
		flag = emps.stream()
			.noneMatch((e) -> e.getStatus().equals(Status.BUSY));
		
		System.out.println(flag);
	}

}
