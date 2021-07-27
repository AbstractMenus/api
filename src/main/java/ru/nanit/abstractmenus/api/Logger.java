package ru.nanit.abstractmenus.api;

public final class Logger {

    private static java.util.logging.Logger logger;

    private Logger(){}

    public static void set(java.util.logging.Logger log){
        logger = log;
    }

    public static void info(String message){
        logger.info(message);
    }

    public static void warning(String message){
        logger.warning(message);
    }

    public static void severe(String message){
        logger.severe(message);
    }

}
