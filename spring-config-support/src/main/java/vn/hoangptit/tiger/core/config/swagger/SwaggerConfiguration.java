package vn.hoangptit.tiger.core.config.swagger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Create file SwaggerConfiguration
 *
 * @author duyhoangptit
 * @since 7/4/2019
 */
@Configuration
@ComponentScan({"vn.hoangptit.tiger.core.config.swagger"})
@EnableSwagger2
@ConditionalOnWebApplication
@EnableConfigurationProperties({SwaggerProperties.class})
public class SwaggerConfiguration implements ImportAware {
    private AnnotationMetadata configMetadata;
    private AnnotationAttributes config;

    @Override
    public void setImportMetadata(AnnotationMetadata annotationMetadata) {
        this.configMetadata = annotationMetadata;
        this.config = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(EnableSwagger.class.getName(), false));

        if (this.config == null) {
            throw new IllegalArgumentException("@EnableSwagger is not present on importing class " + annotationMetadata.getClassName());
        }

    }
}
