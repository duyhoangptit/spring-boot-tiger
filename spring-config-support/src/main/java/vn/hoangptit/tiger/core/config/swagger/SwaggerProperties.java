package vn.hoangptit.tiger.core.config.swagger;

import org.springframework.boot.context.properties.ConfigurationProperties;
import springfox.documentation.service.ApiInfo;

/**
 * Create file SwaggerProperties
 *
 * @author duyhoangptit
 * @since 7/4/2019
 */
@ConfigurationProperties(
        prefix = "swagger"
)
public class SwaggerProperties {
    private ApiInfo api;

    public ApiInfo getApi() {
        return this.api;
    }

    public void setApi(final ApiInfo api) {
        this.api = api;
    }

    public SwaggerProperties() {
        this.api = ApiInfo.DEFAULT;
    }
}
