package com.yundian.fss.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
    private static volatile boolean running = true;
    private static Logger logger = LoggerFactory.getLogger(Launcher.class);

    public static void main(String args[]) {

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
        logger.info("Server launch...........");
        String rootContext ="classpath*:application-context-test.xml";
        if (args.length > 0)
            rootContext = args[0];

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                synchronized (Launcher.class) {
                    running = false;
                    Launcher.class.notify();
                }
            }
        });

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(rootContext);
        context.start();
        logger.info("Server started successful!");
        synchronized (Launcher.class) {
            while (running) {
                try {
                	Launcher.class.wait();
                } catch (Throwable e) {
                    logger.error("Error", e);
                }
            }
        }
    }
}


