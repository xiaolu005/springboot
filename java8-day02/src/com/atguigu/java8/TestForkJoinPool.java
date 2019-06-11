package com.atguigu.java8;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import org.junit.Test;

public class TestForkJoinPool {
	
	@Test
	public void test1(){
		long start = System.currentTimeMillis();
		
		long[] numbers = LongStream.rangeClosed(0, 100000000L).toArray();
		
		ForkJoinTask<Long> task = new ForkJoinSumCalculate(numbers);
		ForkJoinPool pool = new ForkJoinPool();
		Long sum = pool.invoke(task);
		System.out.println(sum);
		
		long end = System.currentTimeMillis();
		
		System.out.println("耗费时间为：" + (end - start));  //687
	}
	
	@Test
	public void test2(){
		long start = System.currentTimeMillis();
		long sum = 0L;
		
		for (int i = 0; i <= 10000000000L; i++) {
			sum += i;
		}
		
		System.out.println(sum);
		
		long end = System.currentTimeMillis();
		System.out.println("耗费时间为：" + (end - start));  //
	}

	//java8
	@Test
	public void test3(){
		long start = System.currentTimeMillis();
		
		Long sum = LongStream.rangeClosed(0, 1000000000000L)
							 .parallel()
							 .reduce(0L, Long::sum);
		
		System.out.println(sum);
		
		long end = System.currentTimeMillis();
		System.out.println("耗费时间为：" + (end - start));  //1513
	}
}
