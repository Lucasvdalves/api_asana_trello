package com.trelloAsanaApi.demo.controller;

import com.trelloAsanaApi.demo.model.*;
import com.trelloAsanaApi.demo.service.AsanaService;
import com.trelloAsanaApi.demo.service.TrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/integracao")
public class IntegracaoController {

    @Autowired
    private TrelloService trelloService;

    @Autowired
    private AsanaService asanaService;

    @PostMapping("/sync")
    public String syncTrelloToAsana(@RequestParam String trelloBoardId) {
        TrelloQuadros board = trelloService.getBoard(trelloBoardId);
        List<ListaTrello> lists = trelloService.getLists(trelloBoardId);

        AsanaProjeto project = new AsanaProjeto();
        project.setNome(board.getNome());
        project.setAnotacoes("Project created from Trello board");

        AsanaProjeto createdProject = asanaService.createProject(project);

        for (ListaTrello list : lists) {
            AsanaSessao section = new AsanaSessao();
            section.setNome(list.getNome());

            AsanaSessao createdSection = asanaService.createSection(createdProject.getId(), section);
            List<CardTrello> cards = trelloService.getCards(list.getId());

            for (CardTrello card : cards) {
                AsanaTarefa task = new AsanaTarefa();
                task.setNome(card.getNome());
                task.setAnotacoes(card.getDesc());
                task.setDue_on(card.getDue());

                asanaService.createTask(createdSection.getId(), task);
            }
        }
        return "Integration Completed Successfully!";
    }

}
