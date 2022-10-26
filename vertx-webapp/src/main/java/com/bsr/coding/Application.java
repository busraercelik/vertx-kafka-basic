package com.bsr.coding;

import com.bsr.coding.tasks.ProducerTask;
import com.bsr.coding.vertex.requests.HelloVerticle;
import com.bsr.coding.vertex.requests.SimpleServerVerticle;
import io.vertx.core.Vertx;

import java.util.Timer;

/**
 * The start() method will be invoked by the vertx instance when the verticle is deployed
 */
public class Application {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new HelloVerticle());
        vertx.deployVerticle(new SimpleServerVerticle());

        // run Producer cron job
        Timer timer = new Timer();
        // This task is scheduled to run every 30 seconds
        timer.scheduleAtFixedRate(new ProducerTask(), 0, 30_000);
    }
}
