package vn.hoangptit.tiger.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hoangptit.tiger.model.TodoList;

/**
 * Create file TodoListRepository
 *
 * @author duyhoangptit
 * @since 6/7/2019
 */
@Repository
public interface TodoListRepo extends JpaRepository<TodoList, Long> {
}
