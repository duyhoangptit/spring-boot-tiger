package vn.hoangptit.tiger.core.config.security;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Create file EnableSecurityService
 *
 * @author duyhoangptit
 * @since 7/4/2019
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
// Nếu chú thích được hiển thị trong văn bản javadoc thì sugget đặt @Document.
@Documented
@Inherited // là chú thích có thể được sử dụng trên các lớp chú thích mà người dùng định nghĩa khác.
// Khi các chú thích do người dùng tử định nghĩa như vậy được sử dụng trên mọi lớp, chúng sẽ tự động kế thừa cho các lớp con
// Và từ đó mọi lớp con hoặc cha đều có config annotation này.
// https://www.logicbig.com/tutorials/core-java-tutorial/annotations/inherited-meta-annotation.html
@Import({SecurityConfiguration.class}) // Có thể import nhiều config ở đây, thêm vào trong dấu ngoặc nhọn
public @interface EnableSecurityService {
}
