package vn.hoangptit.tiger.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class WorkDTO implements Serializable {
    private Long workId;
    private String title;
    private List<TodoListDTO> todoLists;
    private String description;
}
