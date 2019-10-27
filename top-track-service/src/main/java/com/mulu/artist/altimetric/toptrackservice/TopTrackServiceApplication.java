package com.mulu.artist.altimetric.toptrackservice;

import com.mulu.artist.altimetric.toptrackservice.model.APIKey;
import com.mulu.artist.altimetric.toptrackservice.model.URI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class TopTrackServiceApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public URI uri(){
        return new URI();
    }
    @Bean
    public APIKey apiKey(){
        return new APIKey();
    }

    public static void main(String[] args) {
        SpringApplication.run(TopTrackServiceApplication.class, args);
    }

}
