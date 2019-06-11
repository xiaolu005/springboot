package com.atguigu.step;

import org.junit.Test;

public class TestStep{
	@Test
	public void test(){
		long start = System.currentTimeMillis();
		System.out.println(f(100));//165580141
		long end = System.currentTimeMillis();
		System.out.println(end-start);//586ms
	}
	
	//ʵ��f(n)����n��̨�ף�һ���м����߷�
	public int f(int n){
		if(n<1){
			throw new IllegalArgumentException(n + "����С��1");
		}
		if(n==1 || n==2){
			return n;
		}
		return f(n-2) + f(n-1);
	}
}