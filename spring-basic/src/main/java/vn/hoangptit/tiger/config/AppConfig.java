package vn.hoangptit.tiger.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.hoangptit.tiger.model.SimpleBean;

@Configuration
public class AppConfig {

    @Value("${config.mysql.url}")
    private String urlMySql;

    @Value("${config.postgres.url}")
    private String urlPostgres;

    @Bean
    SimpleBean createSimpleBean() {
        return new SimpleBean("hoangtd5");
    }

    @Bean("mysqlConfig")
    DBConnector mysqlConfig() {
        DBConnector dbConnector = new MySqlConnector();

        dbConnector.setUrl(this.urlMySql);

        return dbConnector;
    }

    @Bean("postgresConfig")
    DBConnector postgresConfig() {
        DBConnector dbConnector = new PostgresConnector();

        dbConnector.setUrl(this.urlPostgres);

        return dbConnector;
    }
}
