package vn.hoangptit.tiger.service;

import vn.hoangptit.tiger.dto.TodoListDTO;
import vn.hoangptit.tiger.dto.WorkDTO;

import java.util.List;

/**
 * Create file TodoListService
 *
 * @author duyhoangptit
 * @since 6/7/2019
 */
public interface TodoListService {

    // add
    void addTodoList(TodoListDTO todoListDTO);

    void addWork(WorkDTO workDTO);

    // update
    void updateWork(WorkDTO workDTO);

    void updateTodoList(TodoListDTO todoListDTO);

    // get
    List<TodoListDTO> findAllTodoList();

    // delete
    void deleteWork(WorkDTO workDTO);

    void deleteTodoList(TodoListDTO todoListDTO);
}
