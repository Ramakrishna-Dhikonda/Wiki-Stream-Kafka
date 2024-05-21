package com.wikistream.wikistreamproducer.service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class WikimediaEventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaEventHandler.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topic.name}")
    private String topic;

    public WikimediaEventHandler(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException {

        String wikimediaSourceUrl = "https://stream.wikimedia.org/v2/stream/recentchange";

        EventHandler eventHandler = new WikimediaEventListener(topic, kafkaTemplate);
        EventSource eventSource = new EventSource
                .Builder(eventHandler, URI.create(wikimediaSourceUrl))
                .build();
        LOGGER.info("Initiating data retrieval from Wikimedia");
        eventSource.start();

        Timer timer = new Timer();
        long delay = 2*60*1000; // 2 minutes in milliseconds
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                eventSource.close();
                LOGGER.info("Wikimedia data access stopped.");
                timer.cancel();
            }
        };
        timer.schedule(timerTask, delay);
    }
}
