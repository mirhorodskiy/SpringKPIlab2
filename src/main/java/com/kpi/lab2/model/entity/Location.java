package com.kpi.lab2.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "location_id")
    private Long id;

    @Column(name = "city",unique = true)
    private String cityTitle;

    @Column
    private String region;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "location")
    private Forecast forecastSet;

}