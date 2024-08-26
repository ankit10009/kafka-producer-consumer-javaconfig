package com.example.javatechie.service;

import com.example.javatechie.dto.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageConsumer.class);

    @KafkaListener(topics = "jt-javconfig-demo" ,groupId = "jt-group-json")
    public void consume(Consumer consumer){
        LOGGER.info(String.format("Consumer consume Events : %s", consumer.toString()));
    }


//    @KafkaListener(topics="java-techie-demo-3",groupId = "jt-group3")
//    public void consume1(String message){
//        LOGGER.info(String.format("Consumer 1 Message : %s", message));
//    }
//
//    @KafkaListener(topics="java-techie-demo-3",groupId = "jt-group3")
//    public void consume2Messages(String message){
//        LOGGER.info(String.format("Consumer 2 Message : %s", message));
//    }
//
//    @KafkaListener(topics="java-techie-demo-3",groupId = "jt-group3")
//    public void consume3(String message){
//        LOGGER.info(String.format("Consumer 3 Message : %s", message));
//    }
//
//    @KafkaListener(topics="java-techie-demo-3",groupId = "jt-group3")
//    public void consume4(String message){
//        LOGGER.info(String.format("Consumer 4 Message : %s", message));
//    }



}
