package com.bsr.coding.tasks;

import com.bsr.coding.constants.KafkaConstant;
import com.bsr.coding.kafka.ConsumerCreator;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class ConsumerTask {
    static final Logger LOGGER = LoggerFactory.getLogger(ConsumerTask.class.getName());

    // The fixedRate property runs the scheduled task at every n millisecond.
    // It doesn't check for any previous executions of the task.
    @Scheduled(fixedRate = 30_000)
    public void consumeDataFromKafka() {
        try (Consumer<Long, String> consumer = ConsumerCreator.createConsumer()) {
            // The ConsumerRecords class is a container that holds a list of ConsumerRecord(s)
            // per partition for a particular topic.
            // The poll method is a blocking method waiting for specified time in seconds.
            // If no records are available after the time period specified, the poll method returns an empty ConsumerRecords.
            ConsumerRecords<Long, String> consumerRecords = consumer.poll(Duration.ofSeconds(KafkaConstant.MAX_POLL_INTERVAL));

            consumerRecords.forEach(consumerRecord -> {
                LOGGER.info(String.format("Topic - %s, Partition - %d, Value: %s",
                        consumerRecord.topic(), consumerRecord.partition(), consumerRecord.value()));
            });
            LOGGER.info("Polling completed");
        }
    }
}
