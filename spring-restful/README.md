# Spring Profile

### 1. Tạo file config

application.properties
application.yml

`là file config chính khai báo các enviroment.` 
---
application-{profile-name}.yml(.properties)


* include profile
---

* Sample

spring.profiles: aws<br>
spring.profiles.include: common, aws
---
spring:
  datasource:
    username: xxx
    password: xxx
    url: jdbc:mysql://10.127.24.12:2030/news?useSSL=false&characterEncoding=UTF-8
    
logging:
  level:
    org:
      hibernate:
        SQL: debug
        
### 2. Kích hoạt config

+ C1: Sử dụng `spring.profiles.active` trong file config chính để kích hoạt môi trường cần thiết

    `spring.profiles.active={profile-name}`

+ C2: Active trong code trước khi chạy

    `@Configuration
    public class ApplicationInitializer 
      implements WebApplicationInitializer {
     
        @Override
        public void onStartup(ServletContext servletContext) throws ServletException {
            servletContext.setInitParameter(
              "spring.profiles.active", "aws");
        }
    }`

hoặc 

    `@Autowired
    private ConfigurableEnvironment env;
    ...
    env.setActiveProfiles("aws");`

hoặc setup trong Application main

    `SpringApplication application = new SpringApplication(SpringBootProfilesApplication.class);
    ConfigurableEnvironment environment = new StandardEnvironment();
    environment.setActiveProfiles("aws");
    application.setEnvironment(environment);
    application.run(args);`

+ C3: Sử dụng JVM System parameter

        `-Dspring.profiles.active={profile-name}`

+ C4: Config active in IntelIJ

+ C5: Cách sử dụng @Profile


