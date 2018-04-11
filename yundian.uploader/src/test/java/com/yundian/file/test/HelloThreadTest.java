package com.yundian.file.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class HelloThreadTest
{
    public static void main(String[] args)
    {
    	 BlockingQueue queue = new ArrayBlockingQueue(1024);  
    	  
         Producer producer = new Producer(queue);  
         Consumer consumer = new Consumer(queue);  
   
         new Thread(producer).start();  
         new Thread(consumer).start();  
   
         try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}