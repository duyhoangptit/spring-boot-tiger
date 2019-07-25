package vn.hoangptit.tiger.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;


@Data
@SqlResultSetMapping(
        name = "PersonDTOMapping",
        classes = {
                @ConstructorResult(
                        targetClass = vn.hoangptit.tiger.dto.WorkTodoDTO.class,
                        columns = {
                                @ColumnResult(name = "work_id", type = Long.class),
                                @ColumnResult(name = "title"),
                                @ColumnResult(name = "title_todo"),
                                @ColumnResult(name = "detail")
                        }
                )
        }
)
@Entity
@Table(name = "TBL_WORK")
public class Work extends AuditBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_id")
    private Long workId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "work", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Không sử dụng trong toString()
    private Collection<TodoList> todoLists;
}
