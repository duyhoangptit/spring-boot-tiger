package vn.hoangptit.tiger.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hoangptit.tiger.api.AuthApi;
import vn.hoangptit.tiger.model.request.LoginReq;

/**
 * Create file AuthController
 *
 * @author duyhoangptit
 * @since 6/22/2019
 */
@Slf4j
@RestController
@RequestMapping("authentication")
public class AuthController implements AuthApi {

    public ResponseEntity<?> login(@RequestBody LoginReq loginRes) {
        return ResponseEntity.ok().body(true);
    }
}
