package vn.hoangptit.tiger.sample_annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;

/**
 * Create file ExampleAliasFor
 *
 * @author duyhoangptit
 * @since 7/10/2019
 */
@Configuration
public class ExampleAliasFor {
    public static void main(String[] args) {
        AnnotationAttributes aa = AnnotatedElementUtils
                .getMergedAnnotationAttributes(MyObject2.class, AdminAccess.class);
        System.out.println("attributes of AdminAccess used on MyObject2 " + aa);

        aa = AnnotatedElementUtils
                .getMergedAnnotationAttributes(MyObject2.class, AccessRole.class);
        System.out.println("attributes of AccessRole used on MyObject2 " + aa);
    }
}
