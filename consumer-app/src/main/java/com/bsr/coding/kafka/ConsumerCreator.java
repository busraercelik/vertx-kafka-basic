package com.bsr.coding.kafka;

import com.bsr.coding.constants.KafkaConstant;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Properties;

@Component
public class ConsumerCreator {
    // Create Kafka Consumer Using Topic to Receive Records
    public static Consumer<Long, String> createConsumer() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstant.KAFKA_BROKERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstant.GROUP_ID_CONFIG);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        // Create the consumer using props
        KafkaConsumer<Long, String> consumer = new KafkaConsumer<>(props);
        // subscribe to the topic
        consumer.subscribe(List.of(KafkaConstant.TOPIC_NAME));
        return consumer;
    }
}
