package ua.kondratenko.demo.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 32)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false, length = 32)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 32)
    private String lastName;

    @Column(columnDefinition = "default 'USER")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(columnDefinition = "default 'ACTIVE'")
    @Enumerated(EnumType.STRING)
    private Status status;

}