package com.kpi.lab2.web.controller;

import com.kpi.lab2.model.domain.ForecastDto;
import com.kpi.lab2.model.domain.ForecastWrapper;
import com.kpi.lab2.model.entity.Forecast;
import com.kpi.lab2.model.exception.CityIsNotExistsException;
import com.kpi.lab2.model.exception.DateIsNotExistsException;
import com.kpi.lab2.model.exception.ForecastIsNotExistsException;
import com.kpi.lab2.model.service.AdminService;
import com.kpi.lab2.model.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    AdminService adminService;
    ForecastService forecastService;

    @Autowired
    public AdminController(AdminService adminService, ForecastService forecastService) {
        this.adminService = adminService;
        this.forecastService = forecastService;
    }


    @PostMapping("/addForecast")
    public Forecast addForecast(@RequestBody ForecastWrapper forecastWrapper) {
        return adminService.addForecastWithLocationAndDate(forecastWrapper);
    }

    @DeleteMapping("/removeForecast")
    public void removeForecast(@RequestParam String cityTitle,
                               @RequestParam int day,
                               @RequestParam String month,
                               @RequestParam int year) throws ForecastIsNotExistsException, DateIsNotExistsException, CityIsNotExistsException {
        forecastService.removeForecast(cityTitle, day, month, year);
    }

    @PatchMapping("/updateForecast")
    public Forecast updateForecast(@RequestParam Long id,
                                   @RequestBody ForecastWrapper forecastWrapper) throws ForecastIsNotExistsException {
        return adminService.updateForecast(id, forecastWrapper);
    }

}
