package org.pedrogracia.controller;

import org.pedrogracia.model.DummyModel;
import org.pedrogracia.service.KafkaProducer;
import org.pedrogracia.util.Utilities;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/kafka-simple")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class KafkaController {

    @Inject
    KafkaProducer producer;

    @Inject
    Utilities util;

    private static final int MAX_ITERATIONS = 10000000;

    @GET
    @Path("/produce/{iterations}")
    public Response send(@PathParam("iterations") int iterations) {

        String message = "{\"ERROR\": \"Please set a correct number of iterations. Expected value between 1 and " + MAX_ITERATIONS + "\"}";

        if (Double.isNaN(iterations) || iterations < 1 || iterations > MAX_ITERATIONS) {
            return Response
                    .status(Response.Status.NOT_ACCEPTABLE)
                    .entity(message)
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
        do {
             producer.sendEventToKafka(new DummyModel(util.getRandomString(6), util.getRandomString(10)));
            iterations--;
        } while (iterations > 0);

        // Return an 202 - Accepted response.
        return Response.accepted().build();
    }
}
