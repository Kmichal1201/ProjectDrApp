package com.DrApp.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "specialist")
public class Specialist {

    public Specialist(String email, String name, String surname, LocalDate dateOfBirth, String pwz) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.pwz = pwz;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialist_id")
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "pwz")
    private String pwz;

    @Column(name = "specialization")
    private String specialization;

    @OneToOne(mappedBy = "specialist"
            , cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private User user;

    @OneToMany(mappedBy = "specialist", cascade = CascadeType.ALL)
    private Set<AvailableDate> availableDate;

    @OneToMany(mappedBy = "specialist", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Appointment> appointment;

}