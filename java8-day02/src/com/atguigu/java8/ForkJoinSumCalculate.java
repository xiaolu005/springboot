package com.atguigu.java8;

import java.util.concurrent.RecursiveTask;

public class ForkJoinSumCalculate extends RecursiveTask<Long>{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 123545686796L;
	
	private static final int THRESHOLD = 10000;
	
	private long[] numbers;
	private int start;
	private int end;
	
	public ForkJoinSumCalculate(long[] numbers) {
		this(numbers, 0, numbers.length);
	}
	
	private ForkJoinSumCalculate(long[] numbers, int start, int end){
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		int length = end - start;
		
		if(length <= THRESHOLD){
			return computeSum();
		}else{
			ForkJoinSumCalculate left = new ForkJoinSumCalculate(numbers, start, start + length / 2);
			left.fork(); //加入线程队列
			
			ForkJoinSumCalculate right = new ForkJoinSumCalculate(numbers, start + length / 2, end);
			right.fork();
			
			return left.join() + right.join();
		}
	}
	
	public long computeSum(){
		long sum = 0L;
		
		for (int i = start; i < end; i++) {
			sum += numbers[i];
		}
		
		return sum;
	}

}
