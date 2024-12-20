package sdley.uam.sbcar2;
// package com.example.sbcar2;

import java.util.Arrays;
// import java.util.logging.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sdley.uam.sbcar2.domain.Car;
// import sdley.uam.sbcar2.domain.Car;
import sdley.uam.sbcar2.domain.CarRepository;
import sdley.uam.sbcar2.domain.Owner;
import sdley.uam.sbcar2.domain.OwnerRepository;

@SpringBootApplication
public class SbCar2Application implements CommandLineRunner {

	
	private static final Logger logger = 
			LoggerFactory.getLogger(SbCar2Application.class);
		
	@Autowired
	private CarRepository repository;

	@Autowired
	private OwnerRepository orepository;
	

	public static void main(String[] args) {
		SpringApplication.run(SbCar2Application.class, args);
	}

	@Override
	public void run(String ...args) throws Exception{
		// Add owner objects and save these to db
		Owner owner1 = new Owner("Souleymane", "DIALLO");
		Owner owner2 = new Owner("Ousmane", "KA");
		orepository.saveAll(Arrays.asList(owner1, owner2));

		// Add car object and link to owners and save these to db
		Car car1 = new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000, owner1);
		Car car2 = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000, owner2);
		Car car3 = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000, owner1);
		repository.saveAll(Arrays.asList(car1, car2, car3));
		


		for (Car car : repository.findAll()) {
			logger.info(car.getBrand() + " " + car.getModel());
		}
	}

}

