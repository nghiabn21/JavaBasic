package com.kafka.handler;


import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.springframework.kafka.core.KafkaTemplate;

public class WikimediaChangeHandler implements EventHandler {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic;

    public WikimediaChangeHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }
    @Override
    public void onOpen() {
        System.out.println("Connected to Wikimedia Stream");
    }

    @Override
    public void onClosed() {
        System.out.println("Stream closed");
    }

    @Override
    public void onMessage(String event, MessageEvent messageEvent) {
        System.out.println("Received event: " + messageEvent.getData());
    }

    @Override
    public void onComment(String comment) {}

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }
}
