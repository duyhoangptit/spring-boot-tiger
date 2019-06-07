package vn.hoangptit.tiger.springbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import vn.hoangptit.tiger.config.DBConnector;
import vn.hoangptit.tiger.config.MySqlConnector;
import vn.hoangptit.tiger.config.PostgresConnector;
import vn.hoangptit.tiger.model.Dell;
import vn.hoangptit.tiger.model.Laptop;
import vn.hoangptit.tiger.model.SimpleBean;
import vn.hoangptit.tiger.service.LaptopService;

@ComponentScan("vn.hoangptit.tiger")
@SpringBootApplication
public class SpringBasicApplication {

    public static void main(String[] args) {
        // Application chính là container, chứa toàn bộ các bean
        ApplicationContext context = SpringApplication.run(SpringBasicApplication.class, args);

        // Khi chạy xong, lúc đó các context sẽ chứa các Bean có đánh dấu
        // @Component(@Component, @Service, @Repo.., @Controller, @Configuration)

//        // Lấy ra Bean Laptop
//        Laptop laptop = context.getBean(Laptop.class);
//
//        System.out.println("Instance: " + laptop);
//
//        laptop.display();

        System.out.println("------------------------------------");
        Dell dell = context.getBean(Dell.class);

        System.out.println("Instance: " + dell);

        dell.display();

        System.out.println("------------------------------------");
        LaptopService laptopService = context.getBean(LaptopService.class);

        System.out.println(laptopService);

        Laptop laptop = laptopService.getLaptopRandom();

        laptop.display();

        System.out.println("------------------------------------");

        SimpleBean simpleBean = context.getBean(SimpleBean.class);

        System.out.println("Username: " + simpleBean.getUsername());

        System.out.println("------------------------------------");

        DBConnector mysqlConnector = context.getBean(MySqlConnector.class);

        mysqlConnector.connect();

        System.out.println("------------------------------------");

        DBConnector postgresConnector = context.getBean(PostgresConnector.class);

        postgresConnector.connect();
    }

}
