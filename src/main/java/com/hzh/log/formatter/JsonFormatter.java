package com.hzh.log.formatter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class JsonFormatter implements Formatter {
    @Override
    public String format(ILoggingEvent event) {
        Map<String, String> object = new HashMap<>();
        object.put("level", event.getLevel().levelStr);
        object.put("logger", event.getLoggerName());
        object.put("timestamp", Long.valueOf(event.getTimeStamp()).toString());
        object.put("message", event.getFormattedMessage());
        Gson gson = new Gson();
        return gson.toJson(object);
    }

}
