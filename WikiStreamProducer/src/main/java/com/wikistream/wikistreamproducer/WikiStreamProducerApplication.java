package com.wikistream.wikistreamproducer;

import com.wikistream.wikistreamproducer.service.WikimediaEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WikiStreamProducerApplication implements CommandLineRunner {

    @Autowired
    private WikimediaEventHandler wikimediaEventHandler;

    public static void main(String[] args) {
        SpringApplication.run(WikiStreamProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        wikimediaEventHandler.sendMessage();
    }
}
