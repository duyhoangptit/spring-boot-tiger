package vn.hoangptit.tiger.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hoangptit.tiger.core.entity.UserEntity;

/**
 * Create file UserResponsitory
 *
 * @author duyhoangptit
 * @since 7/3/2019
 */
@Repository
public interface UserResponsitory extends JpaRepository<UserEntity, Long> {

    UserEntity findFirstByUsername(String username);
}
