package com.carvethsolutions.loglib;

import com.carvethsolutions.loglib.handlers.ConsoleHandler;
import com.carvethsolutions.loglib.handlers.FileHandler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Class handles logging messages within a software system.
 * Classes can call the log function to easily document it's activities.
 */
public class Logger {

    private static ArrayList<Handler> handlers = new ArrayList<>();

    static {
        handlers.add(new ConsoleHandler());
    }

    /**
     * Levels of log filtration
     */
    public enum levels {
        ALL,        // All messages (including debug)
        INFO,       // General information about a process. (INFO includes ERROR, WARNING)
        ERROR,      // Used to provide context to exceptions thrown by a class (ERROR includes WARNING)
        WARNING,    // Used to issue warnings that otherwise won't affect behaviour.
        DEBUG,      // Temporary logging level for debugging. Will only be visible on ALL or DEBUG
    }


    /**
     * Assigns a Handler to the Logger
     */
    public static void addHandler(Handler handler) {
        handlers.add(handler);
    }

    /**
     * Revokes a handler from the logger
     * @param handler the handler to remove
     */
    public static void removeHandler(Handler handler) {
        handlers.remove(handler);
    }

    public static void removeAll() {
        handlers.clear();
    }

    public static void log(Loggable caller, String message, Logger.levels level) {
        DateFormat format = new SimpleDateFormat("[yyyy/mm/dd-hh:mm]");
        Date date = new Date();

        for (Handler h : handlers) {
            h.writeMessage(caller.getTag(), message + format.format(date), level);
        }
    }

    public static void log(Loggable caller, String message) {
        log(caller, message, Logger.levels.INFO);
    }

    public static void enableFileLogging() {
        handlers.add(new FileHandler("./logfile.log"));
    }
}
