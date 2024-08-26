package com.example.javatechie.controller;

import com.example.javatechie.dto.Consumer;
import com.example.javatechie.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EventController {

    @Autowired
    private KafkaMessagePublisher publisher;

    @GetMapping("/publish/{msg}")
    public ResponseEntity<?> sendMessage(@PathVariable("msg") String message) {
        try {
            for (int i = 0; i < 10000; i++) {
                publisher.sendMessageToTopic(message + " : " + i);
            }
            return ResponseEntity.ok("Message send to Topic");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to send message");
        }

    }

    @PostMapping("/publish")
    public ResponseEntity<?> sendMessage(@RequestBody Consumer consumer) {
        try {
            publisher.sendJsonMessageToTopic(consumer);
            return ResponseEntity.ok("Message send to Topic");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to send message");
        }
    }

}


