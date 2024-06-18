package com.elo.exemplomskafka.interfaces.controllers;

import com.elo.exemplomskafka.application.services.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class KafkaController {
    private final KafkaService kafkaService;
    private final List<String> mensagensRecebidas = new ArrayList<>();

    @PostMapping("/enviar")
    public String enviarMensagem(@RequestParam("mensagem") String mensagem) {
        kafkaService.enviarMensagem(mensagem);
        return "Mensagem enviada: " + mensagem;
    }

    @KafkaListener(topics = "topico_exemplo", groupId = "group_id")
    public void consumirMensagem(String mensagem) {
        mensagensRecebidas.add(mensagem);
    }

    @GetMapping("/mensagens")
    public List<String> getMensagensRecebidas() {
        return mensagensRecebidas;
    }
}