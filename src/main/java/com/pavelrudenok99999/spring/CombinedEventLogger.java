package com.pavelrudenok99999.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pavel on 17.04.17.
 */

public class CombinedEventLogger implements EventLogger {
    private List<EventLogger> loggerList;

    public CombinedEventLogger() {

    }

    public CombinedEventLogger(List<EventLogger> loggerList) {
        this.loggerList = loggerList;
    }

    public List<EventLogger> getLoggerList() {
        return loggerList;
    }

    public void setLoggerList(List<EventLogger> loggerList) {
        this.loggerList = loggerList;
    }

    @Override
    public void logEvent(Event e) {

        for (EventLogger logger: loggerList) {
            logger.logEvent(e);
        }
    }
}
