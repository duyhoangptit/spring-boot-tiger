package vn.tiger.oauth2.security.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = -4214325494311301431L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Setter
    @Column(name = "last_name")
    private String lastName;

    @Getter
    @Setter
    @Column(name = "user_name", nullable = false)
    @NotEmpty(message = "Please, provide an user name")
    private String userName;

    @Getter
    @Setter
    @Column(name = "email", nullable = false)
    @NotEmpty(message = "Please, provide an email")
    private String email;

    @Getter
    @Setter
    @Column(name = "age")
    private Integer age;

    @Getter
    @Setter
    @Column(name = "password_hash", nullable = false)
    @NotEmpty(message = "Please, provide a password")
    private String passwordHash;

    @Getter
    @Setter
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    @Getter
    @Setter
    private Set<Role> roles;

    @Getter
    @Setter
    @Column(name = "address_street")
    private String street;

    @Getter
    @Setter
    @Column(name = "address_city")
    private String city;

    @Getter
    @Setter
    @Column(name = "address_zip_code")
    private String zipCode;

    @Getter
    @Setter
    @Column(name = "address_lat")
    private Double lat;

    @Getter
    @Setter
    @Column(name = "address_lng")
    private Double lng;

    @Getter
    @Setter
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Getter
    @Setter
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
