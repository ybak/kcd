package com.controller.thread;

public class mythread  extends Thread{
    
	private int count=5;
	
	public mythread(String name){
		
		super();
		this.setName(name);
		
	}
	
	public void run(){
		super.run();
		for(int i=0;i<500;i++){
		System.out.println("i="+(i+1));	
		}
	}
	
	
	public static void main(String[] args) {
		mythread mythread1=new mythread("A");
		mythread1.start();
		try {
			Thread.sleep(2000);
			mythread1.interrupt();
		} catch (InterruptedException e) {
			System.out.println("catch");
			e.printStackTrace();
		}
		
	}
}
