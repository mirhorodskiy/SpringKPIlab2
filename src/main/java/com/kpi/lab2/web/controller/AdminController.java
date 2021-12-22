package com.kpi.lab2.web.controller;

import com.kpi.lab2.model.domain.ForecastWrapper;
import com.kpi.lab2.model.entity.Forecast;
import com.kpi.lab2.model.exception.CityIsNotExistsException;
import com.kpi.lab2.model.exception.DateIsNotExistsException;
import com.kpi.lab2.model.exception.ForecastIsNotExistsException;
import com.kpi.lab2.model.exception.ShortForecastDescriptionException;
import com.kpi.lab2.model.service.AdminService;
import com.kpi.lab2.model.service.ForecastService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Admin", description = "Admin controller, CRUD for forecast")
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
    @Operation(summary = "Add forecast", tags = "Admin", description = "This method creates forecast deserializing request body in JSON")
    public Forecast addForecast(@RequestBody ForecastWrapper forecastWrapper) throws ShortForecastDescriptionException {
        return adminService.addForecastWithLocationAndDate(forecastWrapper);
    }

    @Operation(summary = "Remove forecast", tags = "Admin", description = "This method removes forecast and returns " +
            "status code 200 or 400 with error description if some entered data was wrong")
    @DeleteMapping("/removeForecast")
    public void removeForecast(@RequestParam String cityTitle,
                               @RequestParam int day,
                               @RequestParam String month,
                               @RequestParam int year) throws ForecastIsNotExistsException, DateIsNotExistsException, CityIsNotExistsException {
        forecastService.removeForecast(cityTitle, day, month, year);
    }

    @Operation(summary = "Update forecast", tags = "Admin", description = "This method updates forecast deserializing request body. " +
            "Returns 200 status code or 400 with description of error if some data was wrong")
    @PatchMapping("/updateForecast")
    public Forecast updateForecast(@RequestParam Long id,
                                   @RequestBody ForecastWrapper forecastWrapper) throws ForecastIsNotExistsException {
        return adminService.updateForecast(id, forecastWrapper);
    }

}
