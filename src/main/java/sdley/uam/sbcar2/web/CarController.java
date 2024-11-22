package sdley.uam.sbcar2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sdley.uam.sbcar2.domain.Car;
import sdley.uam.sbcar2.domain.CarRepository;

@RestController
public class CarController {
    @Autowired
    private CarRepository repository;

    @RequestMapping("/cars")
    public Iterable<Car> getCars() {
        return repository.findAll();
    }
}


