package vn.hoangptit.tiger.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import vn.hoangptit.tiger.model.request.LoginReq;

/**
 * Create file AuthApi
 *
 * @author duyhoangptit
 * @since 6/22/2019
 */
public interface AuthApi {

    @PostMapping("login")
    ResponseEntity<?> login(@RequestBody LoginReq loginRes);
}
