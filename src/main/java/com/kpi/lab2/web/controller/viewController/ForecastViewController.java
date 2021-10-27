package com.kpi.lab2.web.controller.viewController;

import com.kpi.lab2.model.exception.CityIsNotExistsException;
import com.kpi.lab2.model.exception.DateIsNotExistsException;
import com.kpi.lab2.model.exception.ForecastIsNotExistsException;
import com.kpi.lab2.model.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/forecast")
public class ForecastViewController {
    ForecastService forecastService;

    @Autowired
    public ForecastViewController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @GetMapping("/getForecastForm")
    public String createForecastForm() {
        return "forms/forecastForm";
    }

    @PostMapping("/get")
    public String getForecast(@RequestParam String cityTitle,
                              @RequestParam int day,
                              @RequestParam String month,
                              @RequestParam int year,
                              Model model) throws ForecastIsNotExistsException, DateIsNotExistsException, CityIsNotExistsException {
//        model.addAttribute("cityTitle", cityTitle);
//        model.addAttribute("day", day);
//        model.addAttribute("month", month);
//        model.addAttribute("year", year);
//        System.out.println(model.getAttribute("cityTitle") + "\n" +
//                model.getAttribute("day") + "\n" +
//                model.getAttribute("month") + "\n" +
//                model.getAttribute("year") + "\n");
        model.addAttribute("forecast", forecastService.getForecast(cityTitle, day, month, year));
        return "forms/getForecast";
    }

}
