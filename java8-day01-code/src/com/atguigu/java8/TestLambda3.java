package com.atguigu.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.junit.Test;

/*
 * Java8 提供的四大核心函数式接口：
 * 
 * Consumer<T> 消费型接口：
 * 		void accept(T t);
 * 
 * Supplier<T> 供给型接口：
 * 		T get();
 * 
 * Function<T, R> 函数型接口：
 * 		R apply(T t);
 * 
 * Predicate<T> 断言型接口：
 * 		boolean test(T t);
 * 
 */
public class TestLambda3 {
	//
	@Test
	public void test4(){
		List<Employee> emps = Arrays.asList(new Employee(101, "张三", 18, 9999.99), new Employee(102, "李四", 22, 6666.99),
				new Employee(103, "王五", 58, 3333.99), new Employee(104, "赵六", 28, 5555.99),
				new Employee(105, "田七", 16, 1111.99));
		
		List<Employee> newList = getList((e) -> e.getAge() >= 18, emps);
		
		newList.forEach(System.out::println);
		
		
		emps.stream()
			.map((e) -> e.getName())
			.collect(Collectors.toSet())
			.forEach(System.out::println);
		
		
	}
	
	public List<Employee> getList(Predicate<Employee> pre, List<Employee> list){
		List<Employee> emps = new ArrayList<Employee>();
		
		for (Employee e : list) {
			if(pre.test(e)){
				emps.add(e);
			}
		}
		
		return emps;
	}
	
	//获取字符串长度
	@Test
	public void test3(){
		Long len = testStr2((str) -> (long)str.length(), "abddfadfef");
		System.out.println(len);
	}
	
	public Long testStr2(Function<String, Long> fun, String str){
		return fun.apply(str);
	}
	
	//生成随机数
	@Test
	public void test2(){
		List<Integer> list = getRandom(() -> (int)(Math.random() * 100), 10);
//		
//		for (Integer num : list) {
//			System.out.println(num);
//		}
		
		list.forEach((x) -> System.out.println(x));
		
	}
	
	public List<Integer> getRandom(Supplier<Integer> sup, int num){
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < num; i++) {
			list.add(sup.get());
		}
		
		return list;
	}
	
	@Test
	public void test1(){
		getLength((x) -> System.out.println(x.length()), "abdef");
	}
	
	public void getLength(Consumer<String> con, String str){
		con.accept(str);
	}

}
