package com.pavelrudenok99999.spring;

import org.springframework.stereotype.Component;

/**
 * Created by pavel on 16.04.17.
 */

public interface EventLogger {
    void logEvent(Event e);
}
