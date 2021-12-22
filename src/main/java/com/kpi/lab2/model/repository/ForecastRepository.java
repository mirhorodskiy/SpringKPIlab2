package com.kpi.lab2.model.repository;

import com.kpi.lab2.model.entity.Date;
import com.kpi.lab2.model.entity.Forecast;
import com.kpi.lab2.model.entity.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForecastRepository extends CrudRepository<Forecast, Long> {

    //Forecast findByLocationAndDate(Location location, Date date);

//    @Query("select distinct f from Forecast f where f.location.id = ?1 and f.date.id = ?2")
//    Forecast findByLocationAndDate(Location location, Date date);

    @Query("select distinct f from Forecast f where f.location.id = ?1 and f.date.id = ?2")
    Forecast findByLocationAndDate(long locationId, long dateId);

    Boolean existsByLocationAndDate(Location location, Date date);

}
