package com.packt.cardatabase.delegate;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.packt.cardatabase.domain.Car;

public class DelegateImp implements Delegate{
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Iterable<Car> getCars() {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(CARS, HashSet.class);
	}

	@Override
	public ResponseEntity<Car> getCar(long id) {
		// TODO Auto-generated method stub
		return restTemplate.getForEntity(CARS+id, Car.class);
	}

	@Override
	public void deleCar(long id) {
		restTemplate.delete(CARS+id);
		
	}

	@Override
	public void addCar(Car car) {
		// TODO Auto-generated method stub
		restTemplate.postForEntity(CARS+"add", car, Car.class);
	}

}
