package com.hzh.log.appender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaAppender extends AppenderBase<ILoggingEvent> {

    private String bootstrapServers;

    private String topic;

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    private Producer<String, String> producer;

    @Override
    public void start() {
        super.start();
        Properties props = new Properties();
        props.put("bootstrap.servers", this.bootstrapServers);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 100);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 1024);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        this.producer = new KafkaProducer<>(props);
        this.producer.send(new ProducerRecord<>(this.topic, "Start app"));
    }

    protected void append(ILoggingEvent event) {
        this.producer.send(new ProducerRecord<>(this.topic, event.getFormattedMessage()));
    }

    @Override
    public void stop() {
        super.stop();
        this.producer.close();
    }
}
