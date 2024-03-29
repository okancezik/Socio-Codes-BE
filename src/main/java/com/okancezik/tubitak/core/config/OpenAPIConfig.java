package com.okancezik.tubitak.core.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Okan Çezik",
                        email = "okacezik@gmail.com",
                        url = "https://www.linkedin.com/in/okancezik/"
                ),
                description = "OpenApi Doc",
                title = "SocioCodes API",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Dev-deploy",
                        url = "http://ec2-35-159-0-56.eu-central-1.compute.amazonaws.com:8090"
                ),
                @Server(
                        description = "Dev-locale",
                        url = "http://localhost:8090"
                )
        },
        security = {
                @SecurityRequirement(name = "bearerAuth")
        }

)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.COOKIE
)
public class OpenAPIConfig {


}
