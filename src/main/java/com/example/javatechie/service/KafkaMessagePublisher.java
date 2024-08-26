package com.example.javatechie.service;

import com.example.javatechie.dto.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String,Object> template;
    private CompletableFuture<SendResult<String, Object>> sendResultCompletableFuture;

    public void sendMessageToTopic(String message){

        CompletableFuture<SendResult<String, Object>> future = template.send("java-techie-demo-3", message);
        future.whenComplete((result,ex) -> {
            if(ex==null){
                System.out.println("Sent Message = [" + message + " ] with Offset [" + result.getRecordMetadata().offset() + "]");
            }
            else{
                System.out.println( "Unable to send message " + ex.getMessage());
            }
        });
    }

    public void sendJsonMessageToTopic(Consumer consumer){

        CompletableFuture<SendResult<String, Object>> future = template.send("jt-javconfig-demo", consumer);
        future.whenComplete((result,ex) -> {
            if(ex==null){
                System.out.println("Sent Json Message = [" + consumer.toString() + " ] with Offset [" + result.getRecordMetadata().offset() + "]");
            }
            else{
                System.out.println( "Unable to send message " + ex.getMessage());
            }
        });
    }

}
