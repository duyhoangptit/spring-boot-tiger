package vn.hoangptit.tiger.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TBL_TODO_LIST")
public class TodoList extends AuditBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_list_id")
    private Long todoListId;
    @Column(name = "title")
    private String title;
    @Column(name = "detail")
    private String detail;

    @ManyToOne(fetch = FetchType.LAZY)// LAZY để tránh việc truy xuất dữ liệu không cần thiết. Lúc nào cần thì mới query
    @JoinColumn(name = "work_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Work work;
}
