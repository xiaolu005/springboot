package com.atguigu.exer;

@FunctionalInterface
public interface MyFunction<T, R> {
	
	public R apply(T t1, T t2);

}
