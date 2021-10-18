package org.pedrogracia.service;

import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KafkaConsumer {

    private final Logger logger = Logger.getLogger(KafkaConsumer.class);

    @Incoming("events-in")
    public void receive(Record<String, String> record) {
        logger.infof("Got a record: %s - %s", record.key(), record.value());
    }
}
