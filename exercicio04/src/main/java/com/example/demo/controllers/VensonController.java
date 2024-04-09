package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.demo.services.VensonService;


@RestController
public class VensonController {
    @Autowired
    private VensonService vensonService;

    private final String nomes;
    private final String sobrenomes;
    private final String posicoes;
    private final String clubes;

    @Autowired
    public VensonController() {
        this.nomes = getDataFromExternalAPI("nomes");
        this.sobrenomes = getDataFromExternalAPI("sobrenomes");
        this.posicoes = getDataFromExternalAPI("posicoes");
        this.clubes = getDataFromExternalAPI("clubes");
    }

    private String getDataFromExternalAPI(String arquivo) {
        String url = "https://venson.net.br/resources/data/" + arquivo + ".txt";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/generateMessage")
    public String generateMessage() {
        return vensonService.generateMessage(this.nomes, this.sobrenomes, this.posicoes, this.clubes);
    }
}
