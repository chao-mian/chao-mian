package com.zhbitzwz.cn;
public class ExceptionDemo2 {
	public static void main(String args[]){
		int n1 = 10;
		int n2 = 0;
		try{
			int result = n1/n2;
			System.out.println("��������Ľ����" + result);
		}catch(ArithmeticException e){
			System.out.println("���ֳ���Ϊ����쳣");
		}finally{
			System.out.println("����finally����еĴ��룬�����Ƿ����쳣���˾�һ��Ҫִ��");
		}
		
	}

}
