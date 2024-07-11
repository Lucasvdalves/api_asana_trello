package com.trelloAsanaApi.demo.model;

import java.util.List;

public class AsanaSessao {

    private String id;
    private String nome;
    private List<AsanaTarefa> tasks;

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

    public List<AsanaTarefa> getTasks() {
        return tasks;
    }

    public void setTasks(List<AsanaTarefa> tasks) {
        this.tasks = tasks;
    }
}
