package vn.hoangptit.tiger.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkTodoDTO implements Serializable {
    private Long workId;
    private String title;
    private String titleTodo;
    private String detail;
}
