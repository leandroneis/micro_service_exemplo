package com.elo.exemplomskafka.infrastructure.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "topico_exemplo", groupId = "group_id")
    public void consumir(String mensagem) {
        log.info(String.format("Mensagem recebida -> %s", mensagem));
        // Processar a mensagem conforme necessário
    }
}