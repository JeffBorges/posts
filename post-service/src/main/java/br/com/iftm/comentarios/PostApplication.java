package br.com.iftm.comentarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@SpringBootApplication
public class PostApplication {

  public static void main(String[] args) {
    SpringApplication.run(PostApplication.class, args);
  }

  @Bean
  public RestTemplate rest(RestTemplateBuilder builder) {
    return builder.build();
  }
}
