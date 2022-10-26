package com.bsr.coding.constants;


public class KafkaConstant {

    private KafkaConstant() {}
    public static final String KAFKA_BROKERS = "127.0.0.1:9092";
    public static final String TOPIC_NAME="channel";
    public static final String GROUP_ID_CONFIG="consumerGroup1";
    public static final Integer MAX_POLL_INTERVAL =10;

    public static final Integer PORT =8085;
}
