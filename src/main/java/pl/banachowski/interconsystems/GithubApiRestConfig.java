package pl.banachowski.interconsystems;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Maciej Banachowski
 * @project gitproxy
 * @email maciej.banachowski@interconsystems.pl
 */
@Configuration
public class GithubApiRestConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder(). build();
    }
}