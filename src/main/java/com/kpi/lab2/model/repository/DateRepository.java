package com.kpi.lab2.model.repository;

import com.kpi.lab2.model.entity.Date;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateRepository extends CrudRepository<Date, Long> {
}
