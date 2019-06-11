package com.atguigu.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.atguigu.java8.Employee.Status;

public class TestStreamAPI2 {
	
	//2. 中间操作
	/*
		映射
		map——接收 Lambda ， 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
		flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
	 */
	@Test
	public void test1(){
		List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
		
		Stream<String> stream = list.stream()
				.map((x) -> x.toUpperCase());
			
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
		emps.stream()
			.map((e) -> e.getSalary())
			.forEach(System.out::println);
	}

	@Test
	public void test3(){
		List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
		
		/*Stream<Stream<Character>> stream = list.stream()
											   .map(TestStreamAPI2::filterCharacter);//{a,a,a}  {b,b,b}
		
		stream.forEach((x) -> {
			x.forEach((y) -> System.out.print(y + " "));
			System.out.println();
		});*/
		
		Stream<Character> stream = list.stream()
			.flatMap(TestStreamAPI2::filterCharacter);
		
		stream.forEach(System.out::println);
	}
	
	public static Stream<Character> filterCharacter(String str){
		List<Character> list = new ArrayList<>();
		
		for (Character ch : str.toCharArray()) {
			list.add(ch);
		}
		
		return list.stream();
	}
	
	//2. 中间操作
	/*
		 排序
		sorted()——自然排序
		sorted(Comparator com)——定制排序
	 */
	@Test
	public void test4(){
		emps.stream()
			.sorted((x, y) -> Integer.compare(x.getAge(), y.getAge()))
			.forEach(System.out::println);
		
		emps.stream()
			.map((e) -> e.getSalary())
			.sorted(Double::compare)
			.forEach(System.out::println);
	}
}
