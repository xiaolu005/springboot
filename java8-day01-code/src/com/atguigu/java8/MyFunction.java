package com.atguigu.java8;

@FunctionalInterface
public interface MyFunction<T> { //接口可以声明自定义泛型接口或普通接口
	
	public T getValue(T t);

}
