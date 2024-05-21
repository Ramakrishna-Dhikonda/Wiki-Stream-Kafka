package com.wikistream.wikistreamproducer.service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public class WikimediaEventListener implements EventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaEventListener.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic;

    public WikimediaEventListener(String topic, KafkaTemplate<String, String> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void onOpen() throws Exception {
        //Method intentionally left empty
    }

    @Override
    public void onClosed() throws Exception {
        //Method intentionally left empty
    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        //LOGGER.info("Received data ::: " + messageEvent.getData());
        kafkaTemplate.send(topic, messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {
        //Method intentionally left empty
    }

    @Override
    public void onError(Throwable throwable) {
        //Method intentionally left empty
    }
}
