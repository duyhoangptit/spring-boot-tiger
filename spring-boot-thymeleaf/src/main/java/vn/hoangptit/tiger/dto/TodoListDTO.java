package vn.hoangptit.tiger.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TodoListDTO implements Serializable {
    private Long todoListId;
    private String title;
    private String detail;
}
