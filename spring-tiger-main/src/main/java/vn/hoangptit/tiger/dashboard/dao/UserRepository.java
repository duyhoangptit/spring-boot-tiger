package vn.hoangptit.tiger.dashboard.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hoangptit.tiger.dashboard.entities.UserEntity;

import java.util.List;

/**
 * Create file UserRepository
 * #An interface can extend multiple interfaces.
 *
 * @author duyhoangptit
 * @since 7/1/2019
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryCustom {
    List<UserEntity> findAllByNameLike(String name, Pageable pageable);
}
