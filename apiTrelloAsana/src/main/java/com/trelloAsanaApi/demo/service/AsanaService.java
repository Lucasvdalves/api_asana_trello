package com.trelloAsanaApi.demo.service;

import com.trelloAsanaApi.demo.model.AsanaProjeto;
import com.trelloAsanaApi.demo.model.AsanaSessao;
import com.trelloAsanaApi.demo.model.AsanaTarefa;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AsanaService {
    @Value("${asana.oauth.client-id}")
    private String clientId;

    @Value("${asana.oauth.client-secret}")
    private String clientSecret;

    @Value("${asana.oauth.token-url}")
    private String tokenUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getAccessToken() {
        return "access_token";
    }

    public AsanaProjeto createProject(AsanaProjeto project) {
        String url = "https://app.asana.com/api/1.0/projects";
        String accessToken = getAccessToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AsanaProjeto> request = new HttpEntity<>(project, headers);
        return restTemplate.postForObject(url, request, AsanaProjeto.class);
    }

    public AsanaSessao createSection(String projectId, AsanaSessao section) {
        String url = String.format("https://app.asana.com/api/1.0/projects/%s/sections", projectId);
        String accessToken = getAccessToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AsanaSessao> request = new HttpEntity<>(section, headers);
        return restTemplate.postForObject(url, request, AsanaSessao.class);
    }

    public AsanaTarefa createTask(String sectionId, AsanaTarefa task) {
        String url = String.format("https://app.asana.com/api/1.0/sections/%s/tasks", sectionId);
        String accessToken = getAccessToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AsanaTarefa> request = new HttpEntity<>(task, headers);
        return restTemplate.postForObject(url, request, AsanaTarefa.class);
    }
}
