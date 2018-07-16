package org.thepoet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class TakeawayApplication {

    public static void main(String[] args) {
        System.out.println("****************************************");
        System.out.println("The Poet's Spring Boot Test Application");
        System.out.println("Spring Version is: " + SpringVersion.getVersion());
        System.out.println("****************************************");
        SpringApplication.run(TakeawayApplication.class, args);
    }
}
