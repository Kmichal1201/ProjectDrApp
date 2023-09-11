package com.DrApp.Model;


import jakarta.persistence.*;
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

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_info_id")
    private UserInfo userInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specialist_id")
    private Specialist specialist;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Role role;

}
