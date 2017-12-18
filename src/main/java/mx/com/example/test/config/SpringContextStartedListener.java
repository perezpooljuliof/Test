package mx.com.example.test.config;


import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;

public class SpringContextStartedListener implements ApplicationListener {

    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("SpringContextStartedListener.onApplicationEvent()>>>>>>>>>>>>>>>>>>>");
        if(event instanceof ContextStartedEvent){
            //ApplicationController.applicationControllerSingleton.isRunning = true;
            System.out.println("event instanceof ContextStartedEvent");
        }

    }

}
