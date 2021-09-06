package ru.lunchVote.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Sweets
@Configuration
public class ConfigSwagger {

    @Bean
    public OpenAPI modeOpenApi(){
        return new OpenAPI().info(new Info()
                .title("LunchVote App API")
                .version("1.0.0")
                .description("Voting for the choice of a restaurant in which there will be lunch. " +
                        "For tests, you can use a pair of login - password, " +
                        "admin - admin for the Admin role. " +
                        "For the role, user: " +
                        "user - user or " +
                        "login - login")
                .contact(new Contact()
                        .name("Alexandr Konstantinov")
                        .email("sweets070@yandex.ru")));

    }
}
