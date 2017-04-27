package com.pavelrudenok99999.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by pavel on 16.04.17.
 */

public class App {
    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;

    public App() {

    }

    public App(Client client, EventLogger defaultLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = defaultLogger;
        this.loggers = loggers;
    }

    public void logEvent(EventType type, Event e) {
        EventLogger logger = loggers.get(type);

        if (logger == null) {
            logger = defaultLogger;
        }

        logger.logEvent(e);
    }

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App)ctx.getBean("app");

        Event event = (Event)ctx.getBean("event");
        app.logEvent(EventType.INFO, event);

        event = (Event)ctx.getBean("event");
        app.logEvent(EventType.ERROR, event);

        LoggingAspect loggingAspect = (LoggingAspect) ctx.getBean("loggingAspect");
        System.out.println(loggingAspect.getLoggersMapCount());



        ctx.close();

//        event = (Event)ctx.getBean("event");
//        app.logEvent(event);
//
//        event = (Event)ctx.getBean("event");
//        app.logEvent(event);
//
//        event = (Event)ctx.getBean("event");
//        app.logEvent(event);

//        ctx.close();
    }
}
