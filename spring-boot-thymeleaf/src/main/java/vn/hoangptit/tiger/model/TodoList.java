package vn.hoangptit.tiger.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TBL_TODO_LIST")
public class TodoList extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_list_id")
    private Long todoListId;
    @Column(name = "title")
    private String title;
    @Column(name = "detail")
    private String detail;
}
