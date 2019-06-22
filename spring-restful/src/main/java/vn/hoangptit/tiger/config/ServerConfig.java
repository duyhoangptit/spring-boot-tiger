package vn.hoangptit.tiger.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Create file ServerConfig
 *
 * @author duyhoangptit
 * @since 6/22/2019
 */
@Configuration
@EnableJpaAuditing// Kích hoạt chức năng Auditing bằng annotation
public class ServerConfig {
}
