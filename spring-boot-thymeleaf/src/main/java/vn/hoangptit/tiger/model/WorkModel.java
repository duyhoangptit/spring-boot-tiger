package vn.hoangptit.tiger.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TBL_WORK")
public class WorkModel extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_id")
    private Long workId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
}
