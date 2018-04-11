package com.yundian.file.test;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{  
  
    protected BlockingQueue queue = null;  
  
    public Consumer(BlockingQueue queue) {  
        this.queue = queue;  
    }  
  
    public void run() {  
        try {  
        	System.out.println(new Date()+"thread-"+Thread.currentThread().getId()+",take:"+queue.take());
        	System.out.println(new Date()+"thread-"+Thread.currentThread().getId()+",take:"+queue.take());
        	System.out.println(new Date()+"thread-"+Thread.currentThread().getId()+",take:"+queue.take());
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }  
}