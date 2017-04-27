package com.pavelrudenok99999.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;

/**
 * Created by pavel on 17.04.17.
 */

public class FileEventLogger implements EventLogger {
    private String filename;
    private File file;

    public FileEventLogger() {

    }

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    public void init() throws IOException {
        file = new File(filename);
        if (!file.canWrite()) {
            throw new IOException("Cannot write to file");
        }
    }

    @Override
    public void logEvent(Event e) {

        PrintWriter pw = null;

        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            pw.println(e.toString());

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
}