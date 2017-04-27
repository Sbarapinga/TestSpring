package com.pavelrudenok99999.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pavel on 17.04.17.
 */

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger() {

    }

    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public void init() {
        cache = new ArrayList<>(cacheSize);
    }

    @Override
    public void logEvent(Event e) {
        cache.add(e);

        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    public void writeEventsFromCache() {
        for (Event event: cache) {
            super.logEvent(event);
        }
    }

    public void destroy() {
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }
}
