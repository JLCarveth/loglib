package com.carvethsolutions.loglib.handlers;

import com.carvethsolutions.loglib.Handler;
import com.carvethsolutions.loglib.Logger;

/**
 * Handles log events by printing them to the console.
 */
public class ConsoleHandler implements Handler {

    private Logger.levels filterLevel;

    /**
     * A default ConsoleHandler will print all messages
     */
    public ConsoleHandler() {
        filterLevel = Logger.levels.ALL;
    }

    public ConsoleHandler(Logger.levels level) {
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
        switch(filterLevel) {
            case ALL:
                print(tag,message,level);
                break;
            case INFO:
                if (level != Logger.levels.DEBUG) {
                    print(tag,message,level);
                }
                break;
            case ERROR:
                if (level == Logger.levels.WARNING || level == Logger.levels.ERROR) {
                    print(tag,message,level);
                }
                break;
            case WARNING:
                if (level == Logger.levels.WARNING) {
                    print(tag,message,level);
                }
                break;
            case DEBUG:
                if (level == Logger.levels.ALL || level == Logger.levels.DEBUG) {
                    print(tag,message,level);
                }
        }
    }

    private void print(String tag, String message, Logger.levels level) {
        System.out.println("[" + tag + "|" + level + "]: " + message);
    }
}
