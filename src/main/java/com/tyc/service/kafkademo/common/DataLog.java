package com.tyc.service.kafkademo.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.slf4j.Log4jMarker;

/**
 * topic对应log4j2中RollingFile name
 */
@Slf4j(topic = "Data")
public class DataLog {

    public static Log4jMarker marker = new Log4jMarker(MarkerManager.getMarker("DATA"));

    public static void info(String dataType, String data,String test) {
        log.info(marker, "{}|{}|{}", dataType, data,test);
    }
}
