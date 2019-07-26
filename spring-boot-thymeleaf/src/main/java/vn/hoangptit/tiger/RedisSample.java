package vn.hoangptit.tiger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Create file RedisSample
 *
 * @author duyhoangptit
 * @since 7/26/2019
 */
@Component
public class RedisSample implements CommandLineRunner {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void run(String... args) throws Exception {
        // Set giá trị của key "loda" là "hello redis"
        redisTemplate.opsForValue().set("loda", "hello world");

        // In ra màn hình Giá trị của key "loda" trong Redis
        System.out.println("Value of key loda: " + redisTemplate.opsForValue().get("loda"));
    }
}
