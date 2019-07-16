package vn.hoangptit.tiger.sample_annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Create file AdminAccess
 *
 * @author duyhoangptit
 * @since 7/10/2019
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@AccessRole("ADMIN")
public @interface AdminAccess {

    // Sẽ tìm annotation và set value của field module bằng value của AdminAccess
    @AliasFor(annotation = AccessRole.class, attribute = "module")
    String value() default "service";
}
