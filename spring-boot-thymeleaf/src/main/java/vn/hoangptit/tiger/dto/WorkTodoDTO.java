package vn.hoangptit.tiger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Create file WorkTodoDTO
 *
 * @author duyhoangptit
 * @since 6/13/2019
 */
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
@AllArgsConstructor
@NoArgsConstructor
public class WorkTodoDTO implements Serializable {
    @Column(name = "work_id")
    private Long workId;
    @Column(name = "title")
    private String title;
    @Column(name = "title_todo")
    private String titleTodo;
    @Column(name = "detail")
    private String detail;
}
