package com.packt.cardatabase.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.services.CarService;

@RestController
public class CarRestController {
	@Autowired
	private CarService carService;

	@RequestMapping("/cars")
	public Iterable<Car> getCars() {
		return carService.getCars();
	}
	
	@RequestMapping("cars/{id}")
	public Optional<Car> getCar(@PathVariable("id") long id){
		return carService.getCar(id);
		
	}
	
	@PostMapping("/cars")
	public Car newCar(@RequestBody Car newCar){
		carService.addCar(newCar);
		return newCar;
		
	}
	
	@DeleteMapping("/cars/{id}")
	  void deleteCar(@PathVariable Long id) {
	    carService.deleteCar(id);
	  }
}