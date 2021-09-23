package com.kpi.lab2.model.repository;

import com.kpi.lab2.model.entity.Date;
import com.kpi.lab2.model.entity.Forecast;
import com.kpi.lab2.model.entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForecastRepository extends CrudRepository<Forecast, Long> {

    Forecast findByLocationAndDate(Location location, Date date);

}
