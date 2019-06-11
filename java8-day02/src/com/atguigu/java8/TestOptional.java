package com.atguigu.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import org.junit.Test;

import com.atguigu.exer.Employee;

public class TestOptional {
	
	/*
		Optional.of(T t) : 创建一个 Optional 实例
		Optional.empty() : 创建一个空的 Optional 实例
		Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
		isPresent() : 判断是否包含值
		orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
		orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
	 */
	@Test
	public void test1(){
		Optional<Employee> op = Optional.of(new Employee());
		/*Employee emp = op.get();
		System.out.println(emp);*/
		
		Optional<Employee> op2 = Optional.ofNullable(new Employee());
//		System.out.println(op2.get());
		
		if(op2.isPresent()){
			System.out.println("包含");
		}
		
		Employee emp = op2.orElse(new Employee());
		System.out.println(emp);
		
		Employee emp2 = op2.orElseGet(Employee::new);
		System.out.println(emp);
	}
	
	@Test
	public void test2(){
		Man man = new Man();
		String name = getGoddessName(man);
		System.out.println(name);
	}

	//需求：获取女神的名字
	public String getGoddessName(Man man){
		if(man != null){
			Woman woman = man.getGoddess();
			
			if(woman != null){
				return woman.getName();
			}
		}
		
		return "苍老师";
	}
	
	@Test
	public void test3(){
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		
		LocalDateTime ldt = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println(ldt);
	}
}
