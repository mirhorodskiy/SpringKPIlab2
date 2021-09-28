package com.kpi.lab2.web.controller;

import com.kpi.lab2.model.domain.ForecastDto;
import com.kpi.lab2.model.domain.ForecastWrapper;
import com.kpi.lab2.model.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @PostMapping("/addForecast")
    public ForecastDto addForecast(@RequestBody ForecastWrapper forecastWrapper) {
        return adminService.addForecastWithLocationAndDate(forecastWrapper);
    }

}
