package vn.hoangptit.tiger.model;

import org.springframework.stereotype.Component;

@Component("vaio")
public class Vaio implements Laptop {

    @Override
    public void display() {
        System.out.println("Vaio");
    }
}
