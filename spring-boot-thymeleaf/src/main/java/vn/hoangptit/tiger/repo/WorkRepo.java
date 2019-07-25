package vn.hoangptit.tiger.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hoangptit.tiger.model.Work;

/**
 * Create file WorkRepositoryRepo
 *
 * @author duyhoangptit
 * @since 6/7/2019
 */
@Repository
public interface WorkRepo extends WorkTodoRepoCustom, JpaRepository<Work, Long> {
}
