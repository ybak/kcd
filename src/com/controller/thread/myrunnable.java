package com.controller.thread;

public class myrunnable implements Runnable{

	
	
	@Override
	public void run() {
		System.out.println("hello runnable");
		
	}

	public static void main(String[] args) {
		
		myrunnable myrunnable=new myrunnable();
		Thread thread=new Thread(myrunnable);
		thread.start();
		System.out.println("½áÊø");
	}
}
