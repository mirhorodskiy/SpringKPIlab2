package com.kpi.lab2.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Date {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "date_id")
    private Long id;

    @Column
    private byte day;

    @Column
    private String month;

    @Column
    private String year;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "date")
    private Set<Forecast> forecastSet;
}
