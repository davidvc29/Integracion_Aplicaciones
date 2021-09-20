package pe.isil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@SpringBootApplication
public class PersonClientApp implements CommandLineRunner {

    private final String URL ="http://localhost:8080";

    private final RestTemplate restTemplate;

    public PersonClientApp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(PersonClientApp.class, args);
    }

    @Bean
    public RestTemplate createRestTemplate(RestTemplateBuilder restTemplateBuilder){
            return restTemplateBuilder.build();
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Iniciando ....");
        ResponseEntity<List> PersonsResponse = restTemplate.getForEntity(URL + "/api/persons", List.class);

        if (PersonsResponse.getStatusCode().is2xxSuccessful()){
            List body = PersonsResponse.getBody();
            body.forEach(p -> log.info(p.toString()));
        }

    }
}
