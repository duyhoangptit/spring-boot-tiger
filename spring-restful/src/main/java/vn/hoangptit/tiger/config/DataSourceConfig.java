package vn.hoangptit.tiger.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Create file DataSourceConfig
 *
 * @author duyhoangptit
 * @since 6/22/2019
 */
@Configuration
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class DataSourceConfig {
    // inject bởi RequiredArgsConstructor. Có hay ko onConstructor = @_(@Autowired) cũng k quan trọng, chỉ làm rõ ràng
    // hơn về việc cách inject mà thôi.
    // inject dao

    @PostConstruct
    public void initData() {
        // init data to DB
    }

}
