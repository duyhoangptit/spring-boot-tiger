package vn.hoangptit.tiger.sample_annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Create file AccessRole
 *
 * @author duyhoangptit
 * @since 7/10/2019
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessRole {

    // https://www.logicbig.com/tutorials/spring-framework/spring-core/alias-for-annotation.html
    @AliasFor("accessType")
    String value() default "visitor";

    @AliasFor("value")
    String accessType() default "visitor";

    String module() default "gui";
}
