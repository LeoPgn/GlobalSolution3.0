package br.com.fiap.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI Documentacao() {
        Server apiServer = new Server();
        apiServer.setUrl("http://localhost:8080");
        apiServer.description("Desenvolvimento do Global Solution");

        Contact dados = new Contact();
        dados.setName("admin");

        Info info = new Info().title("Global Solution")
                .version("1")
                .description("Desenvolvimento do Global Solution");
        return new OpenAPI().info(info).servers(List.of(apiServer));
    }
}
