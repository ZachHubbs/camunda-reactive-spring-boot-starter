package dev.zacharyhubbs.camundareactiveclient.boot.autoconfigure;

import dev.zacharyhubbs.camundareactiveclient.client.TaskClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(TaskClient.class)
@EnableConfigurationProperties(WebClientProperties.class)
public class WebClientAutoConfiguration {


   private WebClientProperties webClientProperties;

   public WebClientAutoConfiguration(WebClientProperties webClientProperties){
       this.webClientProperties = webClientProperties;
   }


}
