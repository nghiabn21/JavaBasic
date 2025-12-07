package com.kafka.listener;

import com.kafka.model.User;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.example.dto.OrderEvent;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaConsumer {

//    @KafkaListener(topics = "Kafka_Example", groupId = "group_id")
//    public void consume(String message) {
//        System.out.println("Consumed message: " + message);
//    }


//    @KafkaListener(topics = "Kafka_Example_json", groupId = "group_json",
//            containerFactory = "userKafkaListenerFactory")
//    public void consumeJson(User user) {
//        System.out.println("Consumed JSON Message: " + user);
//    }
//
//    @KafkaListener(topics = "Kafka_Example_json", groupId = "group_json",
//            containerFactory = "userKafkaListenerFactory")
//    public void consumeJsonTopic(User user) {
//        System.out.println("Consumed JSON Message: " + user);
//    }

    @KafkaListener(topics = "notification", groupId = "group_json")
    public void consumeJsonTopicNotification(User user) {
        log.info("Consumed JSON Message: {}" , user.toString());
    }

    @KafkaListener(topics = "notification_wiki", groupId = "group_json")
    public void consumeJsonTopicNotificationWiki(String user) {
        log.info("Consumed JSON Message wiki: {}" , user);
    }

    @KafkaListener(topics = "order_topic", groupId = "group_json")
    public void consumeJsonTopicOrder(OrderEvent user) {
        log.info("Consumed JSON Message OrderEvent: {}" , user);

        // TODO do something
    }

    // doc message tu 1 partition cu the

    @RetryableTopic(attempts = "4", exclude = {NullPointerException.class, RuntimeException.class})
    // neu that bai thi retry 4 lan va chi dinh ngoai lệ nào k cần retry
    @KafkaListener(topics = "order_topic", groupId = "group_json",
            topicPartitions = {@TopicPartition(topic = "order_topic", partitions = {"3"})})
    public void consumeJsonTopicOrderReadPartition(OrderEvent user) {
        log.info("Consumed JSON Message OrderEvent: {}" , user);

        // TODO do something
    }

    @DltHandler // lang nghe tat ca các tin nhan k thanh cong - dead letter topic
    public void listenDLT(OrderEvent user
            , @Header(KafkaHeaders.RECEIVED_TOPIC) String topic
            , @Header(KafkaHeaders.OFFSET) Long offset) {
        log.info("Consumed DLT: {}, from : {}, offset: {}" , user, topic, offset);
    }

//    @KafkaListener(topics = "request-topic")
//    @SendTo("test-reply-topic")
//    public User receiveMsg(User user) {
//        log.info("Received message: {}", user);
//        return new User("SUCCESS","ITTTT", 12L);
//    }

}
