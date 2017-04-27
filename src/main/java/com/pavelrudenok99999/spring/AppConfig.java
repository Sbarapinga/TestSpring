//package com.pavelrudenok99999.spring;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
//import org.springframework.context.annotation.*;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//import org.springframework.core.env.Environment;
//import org.springframework.core.io.ClassPathResource;
//
//import javax.annotation.Resource;
//import java.text.DateFormat;
//import java.util.*;
//
///**
// * Created by pavel on 18.04.17.
// */
//
//@Configuration
//public class AppConfig {
//
//    @Bean
//    @Scope("prototype")
//    public Date newDate() {
//        return new Date();
//    }
//
//    @Bean
//    public DateFormat dateFormat() {
//        return DateFormat.getDateTimeInstance();
//    }
//
//    @Resource(name = "consoleEventLogger")
//    private EventLogger consoleEventLogger;
//
//    @Resource(name = "fileEventLogger")
//    private EventLogger fileEventLogger;
//
//    @Resource(name = "cacheFileEventLogger")
//    private EventLogger cacheFileEventLogger;
//
//    @Resource(name = "combinedEventLogger")
//    private EventLogger combinedEventLogger;
//
//
//    @Bean
//    public List<EventLogger> loggerList() {
//        List<EventLogger> loggers = new ArrayList<>(2);
//        loggers.add(consoleEventLogger);
//        loggers.add(cacheFileEventLogger);
//        return loggers;
//    }
//
//    @Bean
//    public Map<EventType, EventLogger> loggerMap(){
//        Map<EventType, EventLogger> loggers = new HashMap<>();
//        loggers.put(EventType.INFO, consoleEventLogger);
//        loggers.put(EventType.ERROR, combinedEventLogger);
//        return loggers;
//    }
//
////    @Bean
////    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
////        return new PropertyPlaceholderConfigurer();
////    }
//
//}
