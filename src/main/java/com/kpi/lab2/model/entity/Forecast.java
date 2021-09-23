package com.kpi.lab2.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Forecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "forecast_id")
    private Long id;

    @Column
    int temperature;

    @Column(name = "rain_chance")
    float rainChance;

    @Column
    String description;

    @OneToOne
    @JsonIgnore
    private Location location;

    @ManyToOne
    @JsonIgnore
    private Date date;


}
