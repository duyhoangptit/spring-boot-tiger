package vn.hoangptit.tiger.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import vn.hoangptit.tiger.repo.WorkRepository;
import vn.hoangptit.tiger.repo.impl.WorkTodoCustomImpl;

@ComponentScan("vn.hoangptit.tiger")
@SpringBootApplication
public class SpringBootThymeleafApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootThymeleafApplication.class, args);

        WorkTodoCustomImpl workRepository = context.getBean(WorkTodoCustomImpl.class);

        System.out.println(workRepository.getListWorkTodo());

        System.out.println("DONE");
    }

}
