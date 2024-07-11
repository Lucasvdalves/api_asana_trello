package com.trelloAsanaApi.demo.model;

import java.util.List;

public class AsanaProjeto {
    private String id;
    private String nome;
    private String anotacoes;
    private List<AsanaSessao> sections;

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

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public List<AsanaSessao> getSections() {
        return sections;
    }

    public void setSections(List<AsanaSessao> sections) {
        this.sections = sections;
    }
}
