package com.je.hospital.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;


//Implement OpenApiDefinition by tag
@OpenAPIDefinition(
        info = @Info(
                title = "Hospital API Documentation",
                version = "1.0",
                description = "This is an interface for hospital api rest endpoints documentation.",
                contact = @Contact(
                        name = "Developer",
                        url = "www.hospital-ex.com.mx",
                        email = "admin@hospital-ex.com.mx"
                ),
                license = @License(
                        name = "License for hospital",
                        url = "")

        )

)
@Configuration
public class OpenApiConfiguration {
    //Implement OpenApiDefinition by a bean of OpenApi data type
}
