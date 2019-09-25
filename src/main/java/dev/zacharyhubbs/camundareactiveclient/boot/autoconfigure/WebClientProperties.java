package dev.zacharyhubbs.camundareactiveclient.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "camunda.client")
public class WebClientProperties {


    private String baseUrl;

    public String getBaseUrl(){
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl){
        this.baseUrl = baseUrl;
    }

}
