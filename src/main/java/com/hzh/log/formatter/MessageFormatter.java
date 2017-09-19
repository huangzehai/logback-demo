package com.hzh.log.formatter;

import ch.qos.logback.classic.spi.ILoggingEvent;

public class MessageFormatter implements Formatter {
    @Override
    public String format(ILoggingEvent event) {
        return event.getFormattedMessage();
    }
}
