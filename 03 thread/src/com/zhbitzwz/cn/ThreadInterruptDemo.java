package com.zhbitzwz.cn;
public class ThreadInterruptDemo extends Thread{
	public void run(){
		System.out.println("��Ϣ�����ţ�");
		try{
			sleep(3600000);
		}catch(InterruptedException e){
			System.out.println("����˭�����ҵģ�" );
		}
	}
	public static void main(String args[]){
		ThreadInterruptDemo t =  new ThreadInterruptDemo();
		t.start();
		t.interrupt();//�����߳�
	}

}
