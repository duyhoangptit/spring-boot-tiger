package vn.hoangptit.tiger.core.config.datasource;

import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.lang.annotation.*;

/**
 * Create file EnableJpaConfig
 *
 * @author duyhoangptit
 * @since 6/22/2019
 */
@Inherited
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({JpaConfiguration.class})
public @interface EnableJpaConfig {

    @AliasFor(annotation = EnableJpaRepositories.class,
            attribute = "basePackages")
    String[] basePackages() default {};
}
