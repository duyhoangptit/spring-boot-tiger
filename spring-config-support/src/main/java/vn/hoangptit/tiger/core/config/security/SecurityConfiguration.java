package vn.hoangptit.tiger.core.config.security;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import vn.hoangptit.tiger.core.config.swagger.EnableSwagger;

/**
 * Create file SecurityConfiguration
 *
 * @author duyhoangptit
 * @since 7/4/2019
 */
@Configuration
public class SecurityConfiguration implements ImportAware {
    private AnnotationAttributes config;
    private AnnotationMetadata configMetadata;

    @Bean
    // Điều kiện chỉ khớp khi và chỉ khi lớp hoặc tên bean được chỉ định chưa tồn tại trong BeanFactory
    // Khi được đặt trên một phương thức @Bean, lớp Bean mặc định trả về kiểu của method đó.
    // https://docs.spring.io/spring-boot/docs/2.0.0.RELEASE/api/org/springframework/boot/autoconfigure/condition/ConditionalOnMissingBean.html
    @ConditionalOnMissingBean
    public CorsFilter corsFilter() {
        return new CorsFilter();
    }

    @Override
    public void setImportMetadata(AnnotationMetadata annotationMetadata) {
        this.configMetadata = annotationMetadata;
        this.config = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(EnableSwagger.class.getName(), false));

        if (this.config == null) {
            throw new IllegalArgumentException("@EnableSecurityService is not present on importing class " + annotationMetadata.getClassName());
        }
    }
}
