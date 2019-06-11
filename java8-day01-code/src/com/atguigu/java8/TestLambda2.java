package com.atguigu.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

/*
* 一、Lambda 基础语法：java8 中引入了新的语法和操作符 "->", 该操作符称为 Lambda 操作符或剪头操作符
* 				  Lambda 操作符将 Lambda 表达式分为两个部分：
* 
 * 左侧：Lambda 需要的参数列表
 * 右侧：Lambda 体，即所需要实现的功能
 * 
 * 第一种语法：无参，无返回值
 * 		() -> System.out.println("Hello Lambda!");
 * 
 * 第二种语法：有一个参数，无返回值
 * 		(args) -> System.out.println(args);
 * 
 * 第三种语法：当参数列表中只有一个参数时，小括号可以省略不写
 * 		args -> System.out.println(args);
 * 
 * 第四种语法：有两个参数，有返回值，并且 Lambda 体中有多条语句
 * 		(x, y) -> {
 *			System.out.println("实现函数式接口！");
 *			return Integer.compare(x.length(), y.length());
 *		};
 *
 * 第五种语法：有返回值，但是 Lambda 体中只有一条语句时， 大括号和 return 都可以省略不写
 * 		(x, y) -> Integer.compare(x, y);
 * 
 * 第六种语法：Lambda 表达式左侧的参数类型可以省略，因为 Java 编译器通过上下文可以推断出参数列表的数据类型，即“类型推断”
 * 		(Long x, Long y) -> Integer.compare(x, y);
 * 
 * 
 * 上联：左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 * 
 * 二、Lambda 表达式需要 “函数式接口” 的支持
 * 函数式接口 ： 若一个接口中只有一个抽象方法时，该接口称为“函数式接口”，可以使用注解 @FunctionalInterface 修饰
 * 			  可以检查是否是函数式接口
 */
public class TestLambda2 {
	
	//需求：将一个字符串转换成大写
	@Test
	public void test6(){
		String upStr = testStr((x) -> x.toUpperCase(), "abcdef");
		System.out.println(upStr);
		
		String lowStr = testStr((x) -> x.toLowerCase(), "abDeEE");
		System.out.println(lowStr);
	}
	
	public String testStr(MyFunction<String> mf, String str){
		return mf.getValue(str);
	}
	
	@Test
	public void test5(){
		String[] args = {"aaa", "bbb", "ccc"};
		List<String> list = new ArrayList<>();
		
		show(new HashMap<>());
	}
	
	public void show(Map<String, Integer> map){
		
	}
	
	@Test
	public void test4(){
		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
		System.out.println(com.compare(10, 20));
		
		Comparator<String> comStr = (x, y) -> Integer.compare(x.length(), y.length());
	}
	
	@Test
	public void test3(){
		Comparator<String> com = (x, y) -> {
			System.out.println("实现函数式接口！");
			return Integer.compare(x.length(), y.length());
		};
		
		System.out.println(com.compare("aaa", "qerqy"));
	}
	
	@Test
	public void test2(){
		Consumer<String> con = args -> System.out.println(args);
		con.accept("abcdef");
	}
	
	@Test
	public void test1(){
		Runnable r = new Runnable(){

			@Override
			public void run() {
				System.out.println("Hello World!");
			}
			
		};
		
		r.run();
		
		System.out.println("------------------------------");
		
		//
		Runnable r1 = () -> System.out.println("Hello Lambda!");
		
		r1.run();
	}

}
