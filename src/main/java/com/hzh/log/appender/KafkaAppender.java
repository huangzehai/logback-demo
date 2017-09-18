package com.hzh.log.appender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

public class KafkaAppender extends AppenderBase<ILoggingEvent> {

    protected void append(ILoggingEvent iLoggingEvent) {
        System.out.println("Custom Appender" + iLoggingEvent);
    }
}
