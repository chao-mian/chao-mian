package com.zhbitzwz.cn;
public class ExceptionDemo {
	public static void main(String args[]){
		int n1 = 10;
		int n2 = 0;
		try{
		int result = n1/n2;
		
		System.out.println("��������Ľ����" + result);
		}catch(ArithmeticException e){
			System.out.println("���ֳ���Ϊ����쳣");
		}
	}

}
