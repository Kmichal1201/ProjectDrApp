package com.DrApp.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @NotNull(message = "Pole wymagane.")
    @Column(name = "email")
    private String email;

    @NotNull(message = "Pole wymagane.")
    @Column(name = "password")
    private String password;


    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_info_id")
    private UserInfo userInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specialist_id")
    private Specialist specialist;

    @OneToOne(cascade = CascadeType.MERGE, mappedBy = "user")
    private Role role;

}
