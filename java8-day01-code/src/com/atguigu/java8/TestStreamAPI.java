package com.atguigu.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.atguigu.java8.Employee.Status;

/*
 * Stream API 的操作流程：
 * 
 * 1. 创建 Stream
 * 
 * 2. 中间操作
 * 
 * 3. 终止操作
 */
public class TestStreamAPI {
	
	//1. 创建 Stream
	@Test
	public void test1(){
		//①通过 Collection 系列集合提供的 stream() 方法
		List<String> list = new ArrayList<>();
		Stream<String> stream1 = list.stream();
		
		//②通过 Arrays 工具类中的静态方法 stream()
		Integer[] nums = new Integer[5];
		Stream<Integer> stream2 = Arrays.stream(nums);
		
		//③通过 Stream 类中的静态方法 of 方法
		Stream<Integer> stream3 = Stream.of(1,2,3,5,6,7,78);
		
		//④创建无限流
		//迭代
		Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2)
										.limit(10);
		stream4.forEach(System.out::println);
		
		System.out.println("---------------------");
		
		//生成
		Stream<Double> stream5 = Stream.generate(Math::random).limit(5);
		stream5.forEach(System.out::println);
	}
	
	//2. 中间操作
	/*
	 	筛选与切片
		filter——接收 Lambda ， 从流中排除某些元素。
		limit——截断流，使其元素不超过给定数量。
		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
		distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
	 */
	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99, Status.FREE), 
			new Employee(102, "李四", 22, 6666.99, Status.BUSY),
			new Employee(103, "王五", 58, 3333.99, Status.VOCATION), 
			new Employee(104, "赵六", 28, 5555.99, Status.BUSY),
			new Employee(105, "田七", 16, 1111.99, Status.BUSY),
			new Employee(105, "田七", 16, 1111.99, Status.BUSY));
	
	
	//内部迭代：迭代操作 Stream API 提供
	@Test
	public void test2(){
		//中间操作：不会做任何处理
		Stream<Employee> stream = emps.stream()
									  .filter((e) -> {
										  System.out.println("中间操作");
										  return e.getAge() <= 25;
									  });
		
		//终止操作：一次性执行全部，即“惰性求值”
		stream.forEach(System.out::println);
	}
	
	//外部迭代：
	@Test
	public void test3(){
		Iterator<Employee> it = emps.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

	@Test
	public void test4(){
		emps.stream()
			.filter((x) -> {
				System.out.println("短路！");//&&  ||
				return x.getAge() <= 25;
			})
			.limit(2)
			.forEach(System.out::println);
	}
	
	@Test
	public void test5(){
		emps.stream()
			.filter((x) -> x.getAge() <= 25)
			.skip(1)
			.forEach(System.out::println);
	}
	
	@Test
	public void test6(){
		emps.stream()
			.filter((x) -> x.getSalary() <= 5000)
			.distinct()
			.forEach(System.out::println);
	}
}
