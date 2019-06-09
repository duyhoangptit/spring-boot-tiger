package vn.hoangptit.tiger.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TBL_USER")
public class User extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "description")
    private String description;
}
