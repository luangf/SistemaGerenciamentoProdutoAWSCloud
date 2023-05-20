package br.com.apiproduto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration//Spring injetar os beans na inicialização da aplicação
public class OpenAPIConfig {

	//swagger..
	@Bean //ser injetado na inicialização da aplicação
	public OpenAPI customOpenAPi() {
		return new OpenAPI().info(new Info()
											.title("API PRODUTO")
											.description("API PRODUTO NA CLOUD")
											.contact(new Contact().name("Luan").email("luangf222@gmail.com"))
											.version("1.0.1"));
	}
	
}
