package com.kpi.lab2.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
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

    @ManyToOne
    @JsonIgnore
    private Location location;

    @ManyToOne
    @JsonIgnore
    private Date date;


}
