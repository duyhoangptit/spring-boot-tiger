package vn.hoangptit.tiger.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import vn.hoangptit.tiger.service.PropertyServiceForJasyptStarter;

/**
 * Create file RedisSample
 *
 * @author duyhoangptit
 * @since 7/26/2019
 */
@Component
public class RedisRunner implements CommandLineRunner {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private PropertyServiceForJasyptStarter service;

    @Override
    public void run(String... args) throws Exception {
        // Set giá trị của key "loda" là "hello redis"
        redisTemplate.opsForValue().set("loda", "hello world");

        // In ra màn hình Giá trị của key "loda" trong Redis
        System.out.println("Value of key loda: " + redisTemplate.opsForValue().get("loda"));

        System.out.println("Encrypted: " + this.service.getProperty());
    }
}
