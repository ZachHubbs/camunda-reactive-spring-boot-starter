package dev.zacharyhubbs.camundareactiveclient.client;

import dev.zacharyhubbs.camundareactiveclient.boot.autoconfigure.WebClientProperties;
import org.springframework.web.reactive.function.client.WebClient;

public interface ReactiveClient {

    public void setWebClient(WebClient webClient);

    public void setWebClientProperties(WebClientProperties webClientProperties);


}
