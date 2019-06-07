package vn.hoangptit.tiger.dto;

import lombok.Data;

import java.util.List;

@Data
public class Work {
    private Long workId;
    private String title;
    private List<TodoList> todoLists;
    private String description;
}
