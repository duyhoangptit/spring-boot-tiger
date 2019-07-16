package vn.hoangptit.tiger.core.config.swagger;

import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Create file EnableSwagger
 *
 * @author duyhoangptit
 * @since 7/4/2019
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({SwaggerConfiguration.class})
public @interface EnableSwagger {
    @AliasFor("basePackage")
    String value() default "";

    @AliasFor("value")
    String basePackage() default "";
}
