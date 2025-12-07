package com.kafka.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.handler.WikimediaChangeHandler;
import com.kafka.model.User;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.example.dto.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
//  private final ReplyingKafkaTemplate<String, User, User> replyingKafkaTemplate;

    private static final String TOPIC = "Kafka_Example";

    public void sendMessageOrder(OrderEvent user) {
        log.info("Sending OrderEvent: {}", user.toString());
        Message<OrderEvent> message = MessageBuilder.withPayload(user)
                .setHeader(KafkaHeaders.TOPIC,"order_topic")
                .build();
        kafkaTemplate.send(message);
    }

    //gui den 1 phan vung partition cu the: vd gui den partition 3
    public void sendMessageToPartition(OrderEvent user) {
        log.info("Sending OrderEvent: {}", user.toString());
        CompletableFuture<SendResult<String, Object>> future =
                kafkaTemplate.send("order_topic",3,null, user);
        future.whenComplete((r, e) -> {
            if (e == null) {
                log.info("send success: {}, offset: {}", user.toString(), r.getRecordMetadata().offset());
            }else {
                log.info("Error: {}", e.getMessage());
            }
        });
    }


    public void sendMessage(User user) {
        log.info("Sending user: {}", user.toString());
//        kafkaTemplate.send("notification", user); // gửi theo chuoi string


//        Message<User> message = MessageBuilder.withPayload(user)
//                .setHeader(KafkaHeaders.TOPIC,"notification")
//                .build();
//        kafkaTemplate.send(message);

    }

//    public void sendMessageWiki() throws InterruptedException {
//        String url = "https://stream.wikimedia.org/v2/streams/recentchange";
//        // to read real time  stream data from wikimedia, use event source
//        EventHandler backgroundEventHandler = new WikimediaChangeHandler(kafkaTemplate,"notification_wiki");
//        EventSource eventSource = new EventSource.Builder(backgroundEventHandler, URI.create(url))
//                .reconnectTime(Duration.ofSeconds(5))  // Tăng thời gian chờ khi mất kết nối
//                .build();
//        eventSource.start();
//    }
}
