package com.atguigu.exer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.atguigu.java8.Employee;

public class TestLambda {
	
	@Test
	public void test3(){
		Long sum = getLong((x, y) -> x + y, 10L, 20L);
		System.out.println(sum);
		
		Long result = getLong((x, y) -> x * y, 10L, 20L);
		System.out.println(result);
	}
	
	public Long getLong(MyFunction<Long, Long> mf, long l1, long l2){
		return mf.apply(l1, l2);
	}
	
	@Test
	public void test2(){
		String str = testStr((x) -> x.toUpperCase(), "abcdef");
		System.out.println(str);
		
		String newStr = testStr((x) -> x.substring(2, 4), "abcdef");
		System.out.println(newStr);
	}
	
	public String testStr(MyFun mf, String str){
		return mf.getValue(str);
	}
	
	@Test
	public void test1(){
		List<Employee> emps = Arrays.asList(new Employee(101, "张三", 18, 9999.99), new Employee(102, "李四", 22, 6666.99),
				new Employee(103, "王五", 58, 3333.99), new Employee(104, "赵六", 28, 5555.99),
				new Employee(105, "田七", 16, 1111.99));
		
		Collections.sort(emps, (e1, e2) -> {
			if(e1.getAge() == e2.getAge()){
				return e1.getName().compareTo(e2.getName());
			}else{
				return -Integer.compare(e1.getAge(), e2.getAge());
			}
		});
		
		System.out.println(emps);
	}

}
