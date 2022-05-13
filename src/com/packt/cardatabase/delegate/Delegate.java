package com.packt.cardatabase.delegate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.packt.cardatabase.domain.Car;

public interface Delegate {
	
	public static final String CARS = "/cars/";
	
	public Iterable<Car> getCars();
	public ResponseEntity<Car> getCar(long id);
	public void deleCar(long id);
	public void addCar(Car car);
	public void updateCar(Car car);
}
