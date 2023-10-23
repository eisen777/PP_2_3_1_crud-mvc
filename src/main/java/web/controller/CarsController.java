package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Service.CarService;
import web.model.Car;

import java.util.List;

@Controller
public class CarsController {
    @Autowired
    CarService carService;
    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count", defaultValue = "5") Long count, ModelMap model) {
        List<Car> cars = carService.getCars(count);
        model.addAttribute("cars", cars);
        return "cars";
    }
}
