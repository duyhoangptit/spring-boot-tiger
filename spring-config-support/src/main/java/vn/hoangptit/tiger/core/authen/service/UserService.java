package vn.hoangptit.tiger.core.authen.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Create file UserService
 *
 * @author duyhoangptit
 * @since 7/3/2019
 */
public interface UserService extends UserDetailsService {
    UserDetails findUserByUserId(Long userId);
}
