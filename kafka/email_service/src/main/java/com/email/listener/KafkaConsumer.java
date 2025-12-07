package com.email.listener;

import lombok.extern.log4j.Log4j2;
import org.example.dto.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaConsumer {

    @KafkaListener(topics = "order_topic", groupId = "email")
    public void consumeJsonTopicOrder(OrderEvent user) {
        log.info("Consumed JSON email OrderEvent: {}" , user);

        // TODO do something
    }

}
