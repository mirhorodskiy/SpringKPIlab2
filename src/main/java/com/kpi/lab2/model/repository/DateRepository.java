package com.kpi.lab2.model.repository;

import com.kpi.lab2.model.entity.Date;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DateRepository extends CrudRepository<Date, Long> {


    Date findByDayAndMonthAndYear(byte day, String month, int year);

    Boolean existsByDayAndMonthAndYear(byte day, String month, int year);





}
