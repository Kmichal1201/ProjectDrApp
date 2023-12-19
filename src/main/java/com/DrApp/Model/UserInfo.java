package com.DrApp.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_info_id")
    private long id;


    @NotNull(message = "Pole wymagane.")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Pole wymagane.")
    @Column(name = "surname")
    private String surname;

    @NotNull(message = "Pole wymagane")
    @Size(min = 11, max = 11, message = "Musi zawierać 11 znaków.")
    @Column(name = "id_number")
    private String idNumber;

    @NotNull(message = "Pole wymagane.")
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;


    public UserInfo(String name, String surname, String idNumber, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.idNumber = idNumber;
        this.dateOfBirth = dateOfBirth;
    }

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
            , mappedBy = "userInfo")
    private User user;

    @OneToMany(mappedBy = "userInfo", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Appointment> appointment;

}
