package vn.hoangptit.tiger.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Create file EnableConfig
 *
 * @author duyhoangptit
 * @since 6/22/2019
 */
@Inherited
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({JpaConfiguration.class})
public @interface EnableConfig {
}
