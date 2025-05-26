package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy // <-- Включаем поддержку аспектов
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(application.class, args);
    }

    @EnableAspectJAutoProxy
    @SpringBootApplication
    public class application {
        public static void main(String[] args) {
            SpringApplication.run(application.class, args);
        }
    }
}