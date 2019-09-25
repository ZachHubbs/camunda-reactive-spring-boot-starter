package dev.zacharyhubbs.camundareactiveclient.client;

import dev.zacharyhubbs.camundareactiveclient.boot.autoconfigure.WebClientProperties;
import lombok.Data;
import org.camunda.bpm.engine.rest.dto.task.TaskDto;
import org.camunda.bpm.engine.rest.dto.task.TaskQueryDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class TaskClient {

    private WebClient webClient;
    private WebClientProperties webClientProperties;

    public TaskClient(WebClientProperties webClientProperties) {
        this.webClientProperties = webClientProperties;
        this.webClient = WebClient.create(webClientProperties.getBaseUrl());
    }

    private Mono<ClientResponse> result(String taskId) {

        return webClient.get().uri(uriBuilder -> uriBuilder
                .path("/task/{taskid}")
                .build(taskId))
                .accept(MediaType.APPLICATION_JSON)
                .exchange();
    }

    private Mono<ClientResponse> results(TaskQueryDto taskQueryDto) {

        return webClient.post().uri(uriBuilder -> uriBuilder
                .path("/task")
                .build())
                .body(BodyInserters.fromObject(taskQueryDto))
                .accept(MediaType.APPLICATION_JSON)
                .exchange();
    }

    public TaskDto getTaskById(String taskId) {

        return result(taskId).flatMap(res -> res.bodyToMono(TaskDto.class)).block();

    }

    public List<TaskDto> getTaskByQuery(TaskQueryDto taskQueryDto){

        return results(taskQueryDto).flatMap(res -> res.bodyToMono(List.class)).block();
    }
}
