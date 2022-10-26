package com.bsr.coding.vertex.requests;

import com.bsr.coding.constants.KafkaConstant;
import com.bsr.coding.kafka.ProducerCreator;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

public class SimpleServerVerticle extends AbstractVerticle {
    @Override
    public void start(Promise<Void> startPromise) {
   /*     HttpServer httpServer = getVertx().createHttpServer();
        // The requestHandler() method is called every time the server receives a request
        httpServer.requestHandler(httpServerRequest -> {
            HttpServerResponse httpServerResponse = httpServerRequest.response();
            // Write to the response and end it
            httpServerResponse.end("Welcome to Vertx Intro!");
        }).listen(9090);*/

        Router router = Router.router(getVertx());
        router.get("/api/v1/hello").handler(ctx -> {
            ctx.request().response().end("Hello Vertx");
        });
        router.get("/api/v1/hello/:name").handler(routingContext -> {
            String name = routingContext.pathParam("name");
            ProducerCreator.createProducer();
            routingContext.request().response().end(String.format("Hello %s!", name));
        });

        vertx.createHttpServer().requestHandler(router).listen(KafkaConstant.PORT);
    }
}