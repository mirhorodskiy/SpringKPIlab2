package com.kpi.lab2.model.mapper;

import com.kpi.lab2.model.domain.DateDto;
import com.kpi.lab2.model.entity.Date;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DateMapper {

    public Date dateDtoToEntity(DateDto dateDto) {

        if(dateDto == null)
            return null;
        return  Date.builder()
                .day(dateDto.getDay())
                .month(dateDto.getMonth())
                .year(dateDto.getYear())
                .forecastSet(new HashSet<>())
                .build();
    }
}
