package com.atguigu.single;

/*
 * ����ʽ��
 * 	�����ʼ��ʱֱ�Ӵ���ʵ�����󣬲������Ƿ���Ҫ������󶼻ᴴ��
 * 
 * ��1��������˽�л�
 * ��2�����д����������þ�̬��������
 * ��3�������ṩ���ʵ��
 * ��4��ǿ������һ�����������ǿ�����final�޸�
 */
public class Singleton1 {
	public static final Singleton1 INSTANCE = new Singleton1();
	private Singleton1(){
		
	}
}
