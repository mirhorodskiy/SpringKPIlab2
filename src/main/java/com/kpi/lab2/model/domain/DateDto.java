package com.kpi.lab2.model.domain;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class DateDto {

    private byte day;

    private String month;

    private int year;
}
