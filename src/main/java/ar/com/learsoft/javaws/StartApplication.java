package ar.com.learsoft.javaws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.com.learsoft.javaws.model.Client;

@SpringBootApplication
public class StartApplication {

    // start everything
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    } 
}