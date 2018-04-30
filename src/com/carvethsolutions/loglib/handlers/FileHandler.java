package com.carvethsolutions.loglib.handlers;

import com.carvethsolutions.loglib.Handler;
import com.carvethsolutions.loglib.Loggable;
import com.carvethsolutions.loglib.Logger;

import java.io.*;

public class FileHandler implements Handler {

    private File logFile;

    private Logger.levels filterLevel;

    public FileHandler(String location) {
        logFile = new File(location);
        filterLevel = Logger.levels.INFO;
    }

    public FileHandler(String location, Logger.levels level) {
        logFile = new File(location);
        filterLevel = level;
    }
    /**
     * Write a message to the handler's target
     *
     * @param tag
     * @param message
     * @param level
     */
    @Override
    public void writeMessage(String tag, String message, Logger.levels level) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(logFile, true));
            writer.println("[" + tag + "|" + level + "]: " + message);
            writer.close();
        } catch (IOException e) {
            Logger.log(new Loggable() {
                @Override
                public String getTag() {
                    return "FileHandler";
                }
            }, "IOException when opening logfile @ " + logFile.getAbsolutePath(), Logger.levels.INFO);
            e.printStackTrace();
        }
    }
}
