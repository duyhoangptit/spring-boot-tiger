package vn.hoangptit.tiger.core.config.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import vn.hoangptit.tiger.core.config.auditing.AuditorAwareImpl;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Create file JpaConfiguration
 *
 * @author duyhoangptit
 * @since 6/7/2019
 */

// Spring Data @EnableJpaRepositories : Annotation enable JPA repositories. Nó sẽ scan xác định packages cho Spring Data repositories.
// Spring Boot DataSourceProperties: là các class hữu dụng cho việc cấu hình data source.
// Spring Boot DataSourceBuilder: là các builder, giúp mapping các properties datasource.

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager")
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaConfiguration {

    @Autowired
    private Environment environment;

    @Value("${spring.datasource.config.maxPoolSize}")
    private int maxPoolSize;

    private static final String DEFAULT_PERSISTECE_UNIT = "maria";

    /*
     * Populate SpringBoot DataSourceProperties object directly from application.yml
     * based on prefix.Thanks to .yml, Hierachical data is mapped out of the box with matching-name
     * properties of DataSourceProperties object].
     */
    @Bean
    @Primary// uu tien khoi tao bean nay
    @ConfigurationProperties(prefix = "spring.datasource.config") // Mapping voi config trong properties.
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    /*
     * Configure HikariCP pooled DataSource.
     */
    @Bean(name = "dataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource datasource() {
        DataSourceProperties dataSourceProperties = this.dataSourceProperties();
        HikariDataSource dataSource = DataSourceBuilder
                .create(dataSourceProperties.getClassLoader())
                .driverClassName(dataSourceProperties.getDriverClassName())
                .url(dataSourceProperties.getUrl())
                .username(dataSourceProperties.getUsername())
                // encoding password
                .password(dataSourceProperties.getDataPassword())
                .type(HikariDataSource.class)
                .build();

        // set max pool size
        dataSource.setMaximumPoolSize(maxPoolSize);

        return dataSource;
    }

    /*
     * Entity Manager Factory setup.
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(datasource());
        factoryBean.setPackagesToScan(new String[]{"vn.hoangptit.tiger.model"});
        factoryBean.setPersistenceUnitName(DEFAULT_PERSISTECE_UNIT);
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.setJpaProperties(jpaProperties());

        return factoryBean;
    }

    /*
     * Provider specific adapter.
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        return jpaVendorAdapter;
    }

    /*
     * Here you can specify any provider specific properties.
     */
    private Properties jpaProperties() {
        Properties properties = new Properties();

        properties.put("hibernate.dialect", environment.getRequiredProperty("spring.datasource.config.hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("spring.datasource.config.hibernate.hbm2ddl.method"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("spring.datasource.config.hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("spring.datasource.config.hibernate.format_sql"));
        if (StringUtils.isNotEmpty(environment.getRequiredProperty("spring.datasource.config.defaultSchema"))) {
            properties.put("hibernate.default_schema", environment.getRequiredProperty("spring.datasource.config.defaultSchema"));
        }

        return properties;
    }

    @Bean // Khoi tao Bean transaction
    @Autowired // Inject emf
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager txtManager = new JpaTransactionManager();

        txtManager.setEntityManagerFactory(emf);

        return txtManager;
    }

    /**
     * Config spring auditing
     */
    @Bean
    AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

}
