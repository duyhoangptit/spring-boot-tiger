package vn.hoangptit.tiger.dashboard.domain.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Create file UserEntity
 *
 * @author duyhoangptit
 * @since 7/1/2019
 */
@Data
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
}
