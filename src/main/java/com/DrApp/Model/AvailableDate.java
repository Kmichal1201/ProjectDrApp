package com.DrApp.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "available_date")
public class AvailableDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "available_date_id")
    private long id;

    @Column(name = "availability_date")
    private LocalDate availabilityDate;

    @Column(name = "availability_time")
    private List<LocalTime> availabilityTime;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "specialist_id")
    private Specialist specialist;


    public AvailableDate(LocalDate availabilityDate, List<LocalTime> availabilityTime) {
        this.availabilityDate = availabilityDate;
        this.availabilityTime = availabilityTime;
    }


}
