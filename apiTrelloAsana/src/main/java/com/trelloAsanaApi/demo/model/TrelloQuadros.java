package com.trelloAsanaApi.demo.model;

import java.util.List;

public class TrelloQuadros {
    private String id;
    private String nome;
    private List<ListaTrello> lists;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ListaTrello> getLists() {
        return lists;
    }

    public void setLists(List<ListaTrello> lists) {
        this.lists = lists;
    }
}
