package com.kpi.lab2.model.entity;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "location_id")
    private Long id;

    @Column(name = "city")
    private String cityTitle;

    @Column
    private String region;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private Set<Forecast> forecastSet;

}