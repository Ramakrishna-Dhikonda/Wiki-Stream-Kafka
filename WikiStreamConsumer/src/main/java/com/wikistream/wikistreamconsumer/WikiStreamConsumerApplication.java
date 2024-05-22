package com.wikistream.wikistreamconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
public class WikiStreamConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WikiStreamConsumerApplication.class, args);
	}

}
