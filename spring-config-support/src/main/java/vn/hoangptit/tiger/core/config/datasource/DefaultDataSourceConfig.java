package vn.hoangptit.tiger.core.config.datasource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Create file DefaultDataSourceConfig
 *
 * @author duyhoangptit
 * @since 7/16/2019
 */
@Configuration
@EnableTransactionManagement
public class DefaultDataSourceConfig implements ImportAware {
    private AnnotationAttributes config;
    private AnnotationMetadata configMetadata;

    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {
        this.configMetadata = importMetadata;
        this.config = AnnotationAttributes.fromMap(importMetadata.getAnnotationAttributes(EnableJpaConfig.class.getName(), false));

        if(this.config == null){
            throw new IllegalArgumentException("@EnableJpaConfig is not present on importing class" + this.configMetadata.getClassName());
        }
    }
}
