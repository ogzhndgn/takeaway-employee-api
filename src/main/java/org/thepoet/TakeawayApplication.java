package org.thepoet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EnableWebMvc
public class TakeawayApplication {

    @Value("${project.timezone}")
    private String timeZone;

    public static void main(String[] args) {
        System.out.println("****************************************");
        System.out.println("The Poet's Spring Boot Test Application");
        System.out.println("Spring Version is: " + SpringVersion.getVersion());
        System.out.println("****************************************");
        SpringApplication.run(TakeawayApplication.class, args);
    }

    @PostConstruct
    public void postConstruct() {
        TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
    }
}