package com.bsr.coding.vertex.requests;

import io.vertx.core.AbstractVerticle;

import io.vertx.core.Promise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloVerticle extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloVerticle.class);

    @Override
    public void start(Promise<Void> startPromise) {
        LOGGER.info("Welcome to Vertx");
    }

    @Override
    public void stop() {
        LOGGER.info("Shutting down application");
    }
}
