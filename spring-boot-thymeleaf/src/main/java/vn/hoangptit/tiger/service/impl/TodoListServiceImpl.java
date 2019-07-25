package vn.hoangptit.tiger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.hoangptit.tiger.dto.TodoListDTO;
import vn.hoangptit.tiger.dto.WorkDTO;
import vn.hoangptit.tiger.repo.TodoListRepo;
import vn.hoangptit.tiger.repo.WorkRepo;
import vn.hoangptit.tiger.service.TodoListService;

import java.util.List;

/**
 * Create file TodoListServiceImpl
 *
 * @author duyhoangptit
 * @since 6/7/2019
 */
@Service
@Transactional
public class TodoListServiceImpl implements TodoListService {

    @Autowired
    private TodoListRepo todoListRepository;

    @Autowired
    private WorkRepo workRepository;

    @Override
    public void addTodoList(TodoListDTO todoListDTO) {

    }

    @Override
    public void addWork(WorkDTO workDTO) {

    }

    @Override
    public void updateWork(WorkDTO workDTO) {

    }

    @Override
    public void updateTodoList(TodoListDTO todoListDTO) {

    }

    @Override
    public List<TodoListDTO> findAllTodoList() {
        return null;
    }

    @Override
    public void deleteWork(WorkDTO workDTO) {

    }

    @Override
    public void deleteTodoList(TodoListDTO todoListDTO) {

    }
}
