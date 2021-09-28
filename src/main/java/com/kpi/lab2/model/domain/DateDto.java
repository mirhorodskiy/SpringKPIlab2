package com.kpi.lab2.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DateDto {


    @Min(value = 1)
    @Max(value = 30)
    private Byte day;

    private String month;

    private Integer year;
}
