package vn.hoangptit.tiger.core.authen.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Create file UserEntity
 *
 * @author duyhoangptit
 * @since 7/3/2019
 */
@Data
@Entity
@Table(name = "TBL_USER")
public class UserEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
