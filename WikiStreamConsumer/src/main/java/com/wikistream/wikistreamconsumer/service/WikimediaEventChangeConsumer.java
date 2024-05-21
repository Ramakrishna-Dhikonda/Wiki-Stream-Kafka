package com.wikistream.wikistreamconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WikimediaEventChangeConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaEventChangeConsumer.class);
    @KafkaListener(
            topics = "wikimedia_recentChanges",
            groupId = "wikiEventChange"
    )
    public void consume(String message) {
        LOGGER.info(String.format("Received event :: %s", message));
    }
}
