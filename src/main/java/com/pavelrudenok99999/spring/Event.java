package com.pavelrudenok99999.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by pavel on 17.04.17.
 */

public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df) {

        this.date = date;
        this.df = df;
        this.msg = "message!";

        setRandomId(5, 10);

    }

    public static boolean isDay() {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        return hour >= 8 && hour <= 17;
    }

    public void setRandomId(int min, int max) {
        Random r = new Random();
        id = r.nextInt(max - min + 1) + min;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DateFormat getDf() {
        return df;
    }

    public void setDf(DateFormat df) {
        this.df = df;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", df.format(date), id, msg);
    }
}
