package dev.zacharyhubbs.camundareactiveclient.client;

import dev.zacharyhubbs.camundareactiveclient.boot.autoconfigure.WebClientProperties;
import lombok.Data;
import org.camunda.bpm.engine.rest.dto.runtime.ProcessInstanceQueryDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProcessInstanceClient {


    private WebClient webClient;
    private WebClientProperties webClientProperties;

    public ProcessInstanceClient(WebClientProperties webClientProperties) {
        this.webClientProperties = webClientProperties;
        this.webClient = WebClient.create(webClientProperties.getBaseUrl());
    }
    public Mono<ClientResponse> getProcessInstanceById(String processInstanceId) {

        return webClient.get().uri(uriBuilder -> uriBuilder
                .path("/process-instance/{processInstanceId}")
                .build(processInstanceId))
                .accept(MediaType.APPLICATION_JSON)
                .exchange();
    }

    public Mono<ClientResponse> getProcessInstancesByQuery(ProcessInstanceQueryDto processInstanceQueryDto) {

        return webClient.post().uri(uriBuilder -> uriBuilder
                .path("/process-instance")
                .build())
                .body(BodyInserters.fromObject(processInstanceQueryDto))
                .accept(MediaType.APPLICATION_JSON)
                .exchange();
    }

}
