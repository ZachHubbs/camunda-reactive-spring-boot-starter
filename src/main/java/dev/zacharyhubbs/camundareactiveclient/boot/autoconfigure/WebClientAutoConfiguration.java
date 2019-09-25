package dev.zacharyhubbs.camundareactiveclient.boot.autoconfigure;

import dev.zacharyhubbs.camundareactiveclient.client.ProcessInstanceClient;
import dev.zacharyhubbs.camundareactiveclient.client.TaskClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

@EnableConfigurationProperties(WebClientProperties.class)
public class WebClientAutoConfiguration {


   private WebClientProperties webClientProperties;


   public WebClientAutoConfiguration(WebClientProperties webClientProperties){
       this.webClientProperties = webClientProperties;
   }




}
