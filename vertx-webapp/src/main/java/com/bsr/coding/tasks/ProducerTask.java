package com.bsr.coding.tasks;

import com.bsr.coding.constants.KafkaConstant;
import com.bsr.coding.kafka.ProducerCreator;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

public class ProducerTask extends TimerTask {
    static final Logger LOGGER = LoggerFactory.getLogger(ProducerTask.class.getName());

    @Override
    public void run() {
        // try-with-resources
        try(Producer<Long, String> producer = ProducerCreator.createProducer()) {
            ProducerRecord<Long, String> producerRecord =  new ProducerRecord<>(KafkaConstant.TOPIC_NAME, "This is record ");
            producer.send(producerRecord);
            LOGGER.info("message has been sent!");
        }
    }
}
