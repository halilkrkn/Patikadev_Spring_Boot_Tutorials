package com.halilkrkn.springboottutorials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// Exclude ile dahil edilmesini istemediğimiz yapıları belirtiyoruz ve bir nevi devre dışı bırakıyoruz.
//exclude =  {
//        SecurityAutoConfiguration.class,
//        ManagementWebSecurityAutoConfiguration.class
//}
//@SpringBootApplication(exclude = {
//        SecurityAutoConfiguration.class,
//        ManagementWebSecurityAutoConfiguration.class
//})
@SpringBootApplication
// Auditing
@EnableJpaAuditing(auditorAwareRef = "auditorAware")

public class PatikadevSpringBootTutorialsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatikadevSpringBootTutorialsApplication.class, args);
    }

}