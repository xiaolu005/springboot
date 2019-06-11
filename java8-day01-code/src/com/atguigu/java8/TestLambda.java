package com.atguigu.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

public class TestLambda {

	// 原来的匿名内部类
	@Test
	public void test1() {
		Comparator<String> com = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}

		};

		TreeSet<String> ts = new TreeSet<String>(com);

		TreeSet<String> ts1 = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return 0;
			}

		});
	}

	// 现在的 Lambda 表达式
	@Test
	public void test2() {
		Comparator<String> com = (x, y) -> Integer.compare(x.length(), y.length());
		TreeSet<String> ts = new TreeSet<>((x, y) -> Integer.compare(x.length(), y.length()));
	}

	// 需求：获取公司中年龄小于 35 的 Employee
	public List<Employee> filterEmployees(List<Employee> employees) {
		List<Employee> list = new ArrayList<>();

		for (Employee employee : employees) {
			if (employee.getAge() <= 35) {
				list.add(employee);
			}
		}

		return list;
	}

	// 需求：获取公司中工资大于 5000 的 Employee
	public List<Employee> filterEmployees2(List<Employee> employees) {
		List<Employee> list = new ArrayList<>();

		for (Employee employee : employees) {
			if (employee.getSalary() >= 5000) {
				list.add(employee);
			}
		}

		return list;
	}

	List<Employee> emps = Arrays.asList(new Employee(101, "张三", 18, 9999.99), new Employee(102, "李四", 22, 6666.99),
			new Employee(103, "王五", 58, 3333.99), new Employee(104, "赵六", 28, 5555.99),
			new Employee(105, "田七", 16, 1111.99));

	@Test
	public void test3() {
		List<Employee> list = filterEmployees(emps);

		for (Employee employee : list) {
			System.out.println(employee);
		}
	}

	// 优化方式一：
	public List<Employee> filterEmployee2(List<Employee> list, Predicate<Employee> pre) {
		List<Employee> emps = new ArrayList<>();

		for (Employee employee : list) {
			if (pre.test(employee)) {
				emps.add(employee);
			}
		}

		return emps;
	}

	@Test
	public void test4() {
		List<Employee> list = filterEmployee2(emps, new FilterSalaryEmployeePre());
		
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	
	//优化方式二：
	@Test
	public void test5(){
		List<Employee> list = filterEmployee2(emps, new Predicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				return t.getAge() <= 30;
			}
		});
	}
	
	//优化方式三：
	@Test
	public void test6(){
		List<Employee> list = filterEmployee2(emps, (t) -> t.getAge() <= 30);
		list.forEach(System.out::println);
	}
	
	@Test
	public void test7(){
		emps.stream()
			.filter((t) -> t.getAge() <= 30)
			.limit(1)
			.forEach(System.out::println);
	}
}
