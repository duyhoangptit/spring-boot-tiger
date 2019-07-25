package vn.hoangptit.tiger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import vn.hoangptit.tiger.model.User;
import vn.hoangptit.tiger.repo.UserRepo;
import vn.hoangptit.tiger.repo.WorkRepo;

@SpringBootApplication
public class SpringBootThymeleafApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootThymeleafApplication.class, args);

        WorkRepo workRepository = context.getBean(WorkRepo.class);

        // get data
        System.out.println(workRepository.getListWorkTodo());

        // insert data
        UserRepo userRepo = context.getBean(UserRepo.class);

        User user = User.builder()
                .email("tiger@gmail.com")
                .username("tiger")
                .password("123456")
                .description("Thông tin user")
                .build();
        userRepo.save(user);

        System.out.println("DONE");
    }

}
