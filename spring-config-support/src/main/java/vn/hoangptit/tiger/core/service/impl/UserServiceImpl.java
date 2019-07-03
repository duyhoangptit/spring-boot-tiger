package vn.hoangptit.tiger.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.hoangptit.tiger.core.repo.UserResponsitory;
import vn.hoangptit.tiger.core.dto.UserDto;
import vn.hoangptit.tiger.core.entity.UserEntity;
import vn.hoangptit.tiger.core.service.UserService;

/**
 * Create file UserServiceImpl
 *
 * @author duyhoangptit
 * @since 7/3/2019
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserResponsitory userResponsitory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Kiểm tra xem user có tồn tại trong DB k?
        UserEntity userEntity = this.userResponsitory.findFirstByUsername(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }

        return new UserDto(userEntity);
    }

    public UserDetails findUserByUserId(Long userId) {
        UserEntity userEntity = this.userResponsitory.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not valid with userId: " + userId));

        return new UserDto(userEntity);
    }
}
