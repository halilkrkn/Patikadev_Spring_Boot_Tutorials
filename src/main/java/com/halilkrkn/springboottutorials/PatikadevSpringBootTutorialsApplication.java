package com.halilkrkn.springboottutorials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// Exclude ile dahil edilmesini istemediğimiz yapıları belirtiyoruz ve bir nevi devre dışı bırakıyoruz.
//exclude = SecurityAutoConfiguration.class
@SpringBootApplication(exclude =
        SecurityAutoConfiguration.class
)
public class PatikadevSpringBootTutorialsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatikadevSpringBootTutorialsApplication.class, args);
    }

}