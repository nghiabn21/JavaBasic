package com.kafka.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.model.User;
import com.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.example.dto.Order;
import org.example.dto.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


@Log4j2
@RestController
@RequestMapping("/kafka")
public class UserController {

    //private final KafkaTemplate<String, Object> kafkaTemplate;
//    private final ReplyingKafkaTemplate<String, User, User> replyingKafkaTemplate;

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<?> sendMessage(@RequestBody User name) {
        kafkaProducer.sendMessage(name);
        return new ResponseEntity<>("SEND MESSAGE COMPLETED", HttpStatus.CREATED);
    }

    @PostMapping("/order")
    public ResponseEntity<?> sendMessageOrder(@RequestBody Order name) {
        name.setId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("SEND MESSAGE PENDING");
        orderEvent.setOrder(name);

        kafkaProducer.sendMessageOrder(orderEvent);
        return new ResponseEntity<>("SEND MESSAGE COMPLETED", HttpStatus.CREATED);
    }

//    @GetMapping("/wiki")
//    public ResponseEntity<?> sendMessageWiki() throws InterruptedException {
//        kafkaProducer.sendMessageWiki();
//        return new ResponseEntity<>("SEND MESSAGE COMPLETED", HttpStatus.CREATED);
//    }

//    @GetMapping("/add-topic/{name}")
//    public String addTopic(@PathVariable("name") final String name) {
//
//        kafkaTemplate.send(name, new User(name, "Add Topic Exp", 12000L));
//
//        return "Add Topic success!!!!!";
//    }
//
//    @GetMapping(value = "/reply-kafka")
//    public User replyKafka() throws ExecutionException, InterruptedException, TimeoutException {
//        User user = new User("SENDING", "IT", 10L);
//        ProducerRecord<String, User> producerRecord = new ProducerRecord<>("request-topic", user);
//        RequestReplyFuture<String, User, User> requestReplyFuture = null ;
//        ConsumerRecord<String, User> consumerRecord = null ;
//        try{
//            requestReplyFuture  = replyingKafkaTemplate.sendAndReceive(producerRecord);
//            SendResult<String, User> sendResult = requestReplyFuture.getSendFuture().get();
//            log.info("Message sent successfully: {}", sendResult.getProducerRecord().value());
//
//            consumerRecord = requestReplyFuture.get();
//        }catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
//
//        return consumerRecord.value();
//    }
}
