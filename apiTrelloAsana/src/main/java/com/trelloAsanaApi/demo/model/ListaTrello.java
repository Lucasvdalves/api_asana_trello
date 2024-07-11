package com.trelloAsanaApi.demo.model;

import java.util.List;

public class ListaTrello {
    private String id;
    private String nome;
    private List<TrelloQuadros> cards;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public List<TrelloQuadros> getCards() {
        return cards;
    }

    public void setCards(List<TrelloQuadros> cards) {
        this.cards = cards;
    }
}
