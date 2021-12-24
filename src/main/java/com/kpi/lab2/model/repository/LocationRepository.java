package com.kpi.lab2.model.repository;

import com.kpi.lab2.model.entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {


    Location findByCityTitleAndRegion(String cityTitle, String region);

    Location findByCityTitle(String cityTitle);

    Boolean existsByCityTitle(String cityTitle);
}
