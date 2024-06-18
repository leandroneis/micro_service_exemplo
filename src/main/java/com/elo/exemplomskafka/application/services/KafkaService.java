package com.elo.exemplomskafka.application.services;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaService {
    private static final String TOPIC = "topico_exemplo";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void enviarMensagem(String mensagem) {
        kafkaTemplate.send(TOPIC, mensagem);
    }
}