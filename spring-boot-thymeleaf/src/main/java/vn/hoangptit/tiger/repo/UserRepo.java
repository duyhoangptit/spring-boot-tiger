package vn.hoangptit.tiger.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.hoangptit.tiger.model.User;

/**
 * Create file UserRepo
 *
 * @author duyhoangptit
 * @since 7/25/2019
 */
@Repository
public interface UserRepo extends CrudRepository<User, Long> {
}
