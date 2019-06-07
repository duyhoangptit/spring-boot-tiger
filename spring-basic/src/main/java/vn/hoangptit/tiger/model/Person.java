package vn.hoangptit.tiger.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Person implements CommandLineRunner {

    @Autowired
    @Qualifier("vaio")
    private Laptop laptop1;


    @Autowired
    @Qualifier("dell")
    private Laptop laptop2;

    @PostConstruct
    public void postConstruct(){
        System.out.println("PostConstruct");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("PreDestroy");
    }

    @Override
    public void run(String... args) {
        this.laptop1.display();
        this.laptop2.display();
    }
}
