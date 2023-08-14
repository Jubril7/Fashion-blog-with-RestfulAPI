package com.example.week_8_task_jubril;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Week 8 Task",
                version = "1.0.0",
                description = "Fashion Blog with RestfulAPI",
                termsOfService =  "newArsenal",
                contact = @Contact(
                        name = "Jubril",
                        email = "newArsenal7@arsenal.com"
                ),
                license = @License(
                        name = "licence",
                        url = "newArsenal"
                )
        )
)
public class Week8TaskJubrilApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week8TaskJubrilApplication.class, args);
    }

}
