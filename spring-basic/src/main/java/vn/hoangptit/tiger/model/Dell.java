package vn.hoangptit.tiger.model;

import org.springframework.stereotype.Component;

@Component("dell")
//@Primary // ưu tiên khởi tạo bean khi inject laptop
public class Dell implements Laptop {

    private String name;

    public Dell() {

    }

    public Dell(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("Dell: " + name);
    }
}
