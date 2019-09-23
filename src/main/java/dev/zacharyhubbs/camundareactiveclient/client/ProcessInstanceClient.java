package dev.zacharyhubbs.camundareactiveclient.client;

import dev.zacharyhubbs.camundareactiveclient.boot.autoconfigure.WebClientProperties;
import dev.zacharyhubbs.camundareactiveclient.model.ProcessInstanceImpl;
import lombok.Data;
import org.camunda.bpm.engine.rest.dto.runtime.ProcessInstanceQueryDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Data
@Service
public class ProcessInstanceClient implements ReactiveClient {


    private WebClient webClient;
    private WebClientProperties webClientProperties;

    public ProcessInstanceClient(WebClientProperties webClientProperties) {
        this.webClientProperties = webClientProperties;
        this.webClient = WebClient.create(webClientProperties.getBaseUrl());
    }
    private Mono<ClientResponse> result(String processInstanceId) {

        return webClient.get().uri(uriBuilder -> uriBuilder
                .path("/process-instance/{processInstanceId}")
                .build(processInstanceId))
                .accept(MediaType.APPLICATION_JSON)
                .exchange();
    }

    private Mono<ClientResponse> results(ProcessInstanceQueryDto processInstanceQueryDto) {

        return webClient.post().uri(uriBuilder -> uriBuilder
                .path("/process-instance")
                .build())
                .body(BodyInserters.fromObject(processInstanceQueryDto))
                .accept(MediaType.APPLICATION_JSON)
                .exchange();
    }

    public ProcessInstanceImpl getResult(String processId) {

        return result(processId).flatMap(res -> res.bodyToMono(ProcessInstanceImpl.class)).block();

    }

    public List<ProcessInstanceImpl> getResult(ProcessInstanceQueryDto processInstanceQueryDto){

        return results(processInstanceQueryDto).flatMap(res -> res.bodyToMono(List.class)).block();
    }


}
