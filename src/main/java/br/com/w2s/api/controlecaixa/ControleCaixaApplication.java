package br.com.w2s.api.controlecaixa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {"br.com.w2s.api.controlecaixa"})
@EntityScan(basePackages = {"br.com.w2s.api.controlecaixa.domain.entity"})
@EnableJpaRepositories(basePackages = {"br.com.w2s.api.controlecaixa.domain.repository"})
@OpenAPIDefinition(info = @Info(title = "Controle Caixa Services API", version = "1.0.0", description = "Documentação oficial da API de serviços REST para o sistema de Controle de Caixa"))
public class ControleCaixaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleCaixaApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
