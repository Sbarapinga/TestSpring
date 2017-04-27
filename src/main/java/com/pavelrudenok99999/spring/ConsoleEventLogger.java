package com.pavelrudenok99999.spring;

import org.springframework.stereotype.Component;

/**
 * Created by pavel on 16.04.17.
 */

public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event msg) {
        System.out.println(msg);
    }
}
