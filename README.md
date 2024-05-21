# Wiki-Stream-Kafka
`Wiki-Stream-Kafka` is a Spring Boot application that consumes real-time change events from a Kafka topic named `wikimedia_recentChanges`. This application is part of a microservices architecture where the `wikiStreamProducer` service fetches real-time data from Wikimedia's recent changes and publishes it to Kafka, while this `wikiStreamConsumer` service consumes and processes these messages.

# Configure KAFKA
Ensure that your Kafka server is running and configured properly. The `application.properties` file is set up to connect to a Kafka server running on `localhost:9092` with the following settings:

properties
spring.kafka.consumer.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=wikiEventChange
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.apache.kafka.common.serialization.StringDeserializer

#Verify Consumer
Check the application logs to verify that the consumer is receiving messages from the `wikimedia_recentChanges` topic.

## Current Status

### Completed

- Set up a Kafka producer to retrieve real-time data from Wikimedia recent changes.
- Published the retrieved data to a Kafka broker.
- Set up a Kafka consumer to consume messages from the Kafka topic `wikimedia_recentChanges`.
- Logged the consumed messages to the console.

### Future Plans

- Add web pages to display the consumed messages.
- Create models to represent the messages more formally.
- Present the output on a webpage in the consumer application for better visualization and analysis.
