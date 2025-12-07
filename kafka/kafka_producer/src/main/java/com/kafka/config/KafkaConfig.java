package com.kafka.config;

import com.kafka.model.User;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@EnableKafka
@Configuration
public class KafkaConfig {

    private static final String KAFKA_SERVER = "localhost:9092";
    private static final String GROUP_ID = "group_id";

//    @Bean
//    public Map<String, String> producerConfigs() {
//        Map<String, String> config = new HashMap<>();
//
//        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER);
//        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, String.valueOf(StringSerializer.class));
//        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, String.valueOf(StringSerializer.class));
//
//        return config;
//    }

//    @Bean
//    public ProducerFactory<String, String> producerFactory() {
//        return new DefaultKafkaProducerFactory<>(producerConfigs());
//    }
//
//    @Bean
//    public KafkaTemplate<String, String> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }

    @Bean
    public NewTopic newTopic(){
        return TopicBuilder.name("notification")
//                .partitions(10) // 1 topic chia lam 10 partitions
                .build();
    }

    @Bean
    public NewTopic newTopicOrder(){
        return TopicBuilder.name("order_topic")
//                .partitions(10) // 1 topic chia lam 10 partitions
                .build();
    }

    @Bean
    public NewTopic newTopicWiki(){
        return TopicBuilder.name("notification_wiki")
                .build();
    }

//    --------------------------- cau hinh cho reply ----------------------------------------

//    @Bean
//    public Map<String, Object> consumerConfigs() {
//        Map<String, Object> config = new HashMap<>();
//
//        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER);
//        config.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
//        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//
//        return config;
//    }
//
//    @Bean
//    public ConsumerFactory<String, User> consumerFactory() {
//        return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(), new JsonDeserializer<>(User.class));
//    }

//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, User> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, User> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }

//    @Bean
//    public ReplyingKafkaTemplate<String, User, User> replyKafkaTemplate(ProducerFactory<String, User> pf,
//                                                                        KafkaMessageListenerContainer<String, User> container) {
//        return new ReplyingKafkaTemplate<>(pf, container);
//    }
//
//    @Bean
//    public KafkaMessageListenerContainer<String, User> replyContainer(ConsumerFactory<String, User> cf) {
//        ContainerProperties containerProperties = new ContainerProperties(Pattern.compile("test-.*"));
//        return new KafkaMessageListenerContainer<>(cf, containerProperties);
//    }

}
