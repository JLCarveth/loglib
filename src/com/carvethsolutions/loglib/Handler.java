package com.carvethsolutions.loglib;

public interface Handler {
    /**
     * Write a message to the handler's target
     * @param message
     */
    void writeMessage(String tag, String message, Logger.levels level);
}
