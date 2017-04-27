package com.pavelrudenok99999.spring;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by pavel on 22.04.17.
 */
public class DBLogger implements EventLogger {
    private JdbcTemplate jdbcTemplate;

    public void logEvent(Event e) {

    }
}
