package com.packt.cardatabase.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.packt.cardatabase.delegate.DelegateImp;
import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.repositories.CarRepository;

@Service
public class CarService {
	@Autowired
	private CarRepository repository;
	@Autowired
	private DelegateImp delegate;

	public void addCar(Car car) {
		repository.save(car);
	}

	public void deleteCar(Car car) {
		repository.delete(car);
	}

	public Optional<Car> getCar(long carId) {
		return repository.findById(carId);
	}

	public Iterable<Car> getCars() {
		return repository.findAll();
	}
	
	public void deleteCar(long carId) {
		Optional<Car> car = repository.findById(carId);
		repository.delete(car.get());
	}
	
	public void updateCar(Car c) {
		delegate.updateCar(c);
	}
}