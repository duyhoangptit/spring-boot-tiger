package vn.hoangptit.tiger.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("vn.hoangptit.tiger")
@SpringBootApplication
public class SpringBootThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootThymeleafApplication.class, args);
    }

}
