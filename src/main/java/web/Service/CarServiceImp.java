package web.Service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImp implements CarService{
    private static long CARS_COUNT;
    List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(++CARS_COUNT, "SSC", "Tuatara"));
        cars.add(new Car(++CARS_COUNT, "Aston Martin", "DBS Superleggera"));
        cars.add(new Car(++CARS_COUNT, "Mercedes-Benz", "Maybach Exelero"));
        cars.add(new Car(++CARS_COUNT, "Bentley", "Hunaudiere Concept"));
        cars.add(new Car(++CARS_COUNT, "Ferrari", "488"));
    }
    @Override
    public List<Car> getCars(Long count) {
        if (count <= 0 || count > 5) return cars;
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
