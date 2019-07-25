package vn.hoangptit.tiger.repo;

import org.springframework.stereotype.Repository;
import vn.hoangptit.tiger.dto.WorkTodoDTO;

import java.util.List;

/**
 * Create file WorkTodoRepoCustom
 *
 * @author duyhoangptit
 * @since 6/13/2019
 */
public interface WorkTodoRepoCustom {
    List<WorkTodoDTO> getListWorkTodo();
}
