package org.pedrogracia.service;

import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.OnOverflow;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.pedrogracia.model.DummyModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class KafkaProducer {

    @Inject
    @Channel("events-out")
    @OnOverflow(value = OnOverflow.Strategy.UNBOUNDED_BUFFER)
    Emitter<Record<String, String>> emitter;

    public void sendEventToKafka(DummyModel dummy) {
        emitter.send(Record.of(dummy.key, dummy.value));
    }

}
