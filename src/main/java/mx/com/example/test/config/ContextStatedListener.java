package mx.com.example.test.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextStatedListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("Context Destroyed");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("ContextStatedListener.contextInitialized()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<");

    }

}