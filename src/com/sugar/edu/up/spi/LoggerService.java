package com.sugar.edu.up.spi;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @Description todo
 * @Author sugar
 * @Date 2024/6/26 11:19 PM
 * @Version 1.0
 */
public class LoggerService {

    private static final LoggerService SERVICE=new LoggerService();
    private final Logger logger;
    private final List<Logger> loggerList;
    private LoggerService(){
        ServiceLoader<Logger> loader=ServiceLoader.load(Logger.class);
        List<Logger> list=new ArrayList<>();
        for (Logger log: loader){
            list.add(log);
        }
        loggerList=list;
        if (!list.isEmpty()){
            logger=list.get(0);
        }else {
            logger=null;
        }
    }

    public static LoggerService getService(){
        return SERVICE;
    }

    public void info(String msg) {
        if (logger == null) {
            System.out.println("info 中没有发现Logger服务提供者");
        }else {
            logger.info(msg);
        }
    }

    public void debug(String msg){
        if (loggerList.isEmpty()) {
            System.out.println("debug 中没有发现Logger服务提供者");
        }
        loggerList.forEach(log->log.debug(msg));
    }
}
