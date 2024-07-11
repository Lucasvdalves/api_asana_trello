package com.trelloAsanaApi.demo.service;

import com.trelloAsanaApi.demo.model.CardTrello;
import com.trelloAsanaApi.demo.model.ListaTrello;
import com.trelloAsanaApi.demo.model.TrelloQuadros;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TrelloService {
    @Value("${trello.api.key}")
    private String apiKey;

    @Value("${trello.api.token}")
    private String apiToken;

    private final RestTemplate restTemplate = new RestTemplate();

    public TrelloQuadros getBoard(String boardId) {
        String url = String.format("https://api.trello.com/1/boards/%s?key=%s&token=%s", boardId, apiKey, apiToken);
        return restTemplate.getForObject(url, TrelloQuadros.class);
    }

    public List<ListaTrello> getLists(String boardId) {
        String url = String.format("https://api.trello.com/1/boards/%s/lists?key=%s&token=%s", boardId, apiKey, apiToken);
        ListaTrello[] lists = restTemplate.getForObject(url, ListaTrello[].class);
        return Arrays.asList(lists);
    }

    public List<CardTrello> getCards(String listId) {
        String url = String.format("https://api.trello.com/1/lists/%s/cards?key=%s&token=%s", listId, apiKey, apiToken);
        CardTrello[] cards = restTemplate.getForObject(url, CardTrello[].class);
        return Arrays.asList(cards);
    }

}






