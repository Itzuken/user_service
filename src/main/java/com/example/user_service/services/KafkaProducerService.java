package com.example.user_service.services;

import com.example.user_service.dto.UserEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Value("${app.kafka.topic:user-events}")
    private String topic;

    private final KafkaTemplate<String, UserEventDTO> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, UserEventDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendUserEvent(String operation, String email, String userName) {
        UserEventDTO event = new UserEventDTO(operation, email, userName);
        kafkaTemplate.send(topic, event);
    }
}