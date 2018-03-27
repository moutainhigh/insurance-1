package com.yundian.toolkit.daemon;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static volatile boolean running = true;
	
	public static void main(String args[]){
		
		/*PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			Resource[] resources = resolver.getResources("classpath*:applicationContext.xml");
			for(Resource r:resources){
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{r.getURL().toString()});
		        context.start();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}*/
        
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                synchronized (Main.class) {
                    running = false;
                    Main.class.notify();
                }
            }
        });
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:conf/applicationContext*.xml");
        context.start();
 
        synchronized (Main.class) {
            while (running) {
                try {
                    Main.class.wait();
                } catch (Throwable e) {
                }
            }
        }
	}
}
