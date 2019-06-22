package vn.hoangptit.tiger.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Create file DataSourceProperties
 *
 * @author duyhoangptit
 * @since 6/22/2019
 */
@Data
@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "datasource")
public class DataSourceProperties {
    private String url;
    private String username;
    private String password;
}
