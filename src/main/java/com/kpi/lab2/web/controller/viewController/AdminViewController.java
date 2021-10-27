package com.kpi.lab2.web.controller.viewController;

import com.kpi.lab2.model.domain.ForecastWrapper;
import com.kpi.lab2.model.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminViewController {
    AdminService adminService;

    @Autowired
    public AdminViewController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/formPage")
    public String createForm(Model model){
        model.addAttribute("forecastWrapper", new ForecastWrapper());
        return "forms/addForecast";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("forecastWrapper") ForecastWrapper forecastWrapper) {
        adminService.addForecastWithLocationAndDate(forecastWrapper);
        return "forms/addForecast";
    }
}
