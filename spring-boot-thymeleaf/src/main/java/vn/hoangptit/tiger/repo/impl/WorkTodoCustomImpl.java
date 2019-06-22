package vn.hoangptit.tiger.repo.impl;

import vn.hoangptit.tiger.dto.WorkTodoDTO;
import vn.hoangptit.tiger.repo.WorkTodoCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Create file WorkTodoCustomImpl
 *
 * @author duyhoangptit
 * @since 6/13/2019
 */
public class WorkTodoCustomImpl implements WorkTodoCustom {

    @PersistenceContext(unitName = "maria")
    private EntityManager em;

    @Override

    public List<WorkTodoDTO> getListWorkTodo() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT w.work_id, w.title, t.title as title_todo, t.detail ");
        sb.append("FROM tbl_work w INNER JOIN tbl_todo_list t ON w.work_id = t.todo_list_id ");

        List<WorkTodoDTO> workTodoDTOS = em.createNativeQuery(sb.toString(), "PersonDTOMapping").getResultList();

        return workTodoDTOS;
    }
}
