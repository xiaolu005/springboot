package com.atguigu.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import com.atguigu.exer.Employee;
import com.atguigu.exer.Employee.Status;

public class TestStreamAPI {

    //3. 终止操作
	/*
	 * 收集：collect(Collector c) 流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
	 */
	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99, Status.FREE), 
			new Employee(102, "李四", 22, 6666.99, Status.BUSY),
			new Employee(103, "王五", 58, 3333.99, Status.BUSY), 
			new Employee(104, "赵六", 28, 5555.99, Status.BUSY),
			new Employee(105, "田七", 16, 1111.99, Status.BUSY),
			new Employee(105, "田七", 16, 1111.99, Status.BUSY));
	
	@Test
	public void test1(){
		List<String> list = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.toList());
		
		list.forEach(System.out::println);
		
		System.out.println("---------------------------");
		Set<String> set = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.toSet());
		
		set.forEach(System.out::println);

		System.out.println("---------------------------");
		
		HashSet<String> hs = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.toCollection(HashSet::new));
		
		hs.forEach(System.out::println);
	}
	
	@Test
	public void test2(){
		Long count = emps.stream()
			.collect(Collectors.counting());
		System.out.println(count);
		
		Double sum = emps.stream()
			.collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println(sum);
		
		Double avg = emps.stream()
			.collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println(avg);
		
		Optional<Employee> max = emps.stream()
			.collect(Collectors.maxBy((x, y) -> Double.compare(x.getSalary(), y.getSalary())));
		System.out.println(max.get());
		
		Optional<Double> min = emps.stream()
			.map((e) -> e.getSalary())
			.collect(Collectors.minBy(Double::compare));
		System.out.println(min.get());
	}
	
	//分组
	@Test
	public void test3(){
		Map<Status, List<Employee>> map = emps.stream()
			.collect(Collectors.groupingBy((e) -> e.getStatus()));
		
		System.out.println(map);
	}
	
	//多级分组
	@Test
	public void test4(){
		Map<Status, Map<String, List<Employee>>> map =
		emps.stream()
			.collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
				if(e.getAge() <= 30) return "青年";
				else if(e.getAge() <= 60) return "中年";
				else return "老年";
			})));
		
		System.out.println(map);
	}
	
	//分区
	@Test
	public void test5(){
		Map<Boolean, List<Employee>> map = emps.stream()
			.collect(Collectors.partitioningBy((e) -> e.getSalary() <= 5000.0));
		
		System.out.println(map);
	}
}
