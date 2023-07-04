package com.packt.cardatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner{
	private static final Logger logger = 
			LoggerFactory.getLogger(CardatabaseApplication.class);
	
	@Autowired
	private CarRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application started");
	}
	
	@Override
	public void run(String... args) throws Exception {
		//이곳에 코드를 추가
		repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000));
		repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000));
		repository.save(new Car("Toyota", "pRIUS", "Silver", "KKO-0212", 2020, 39000));
		
		//모든 자동차를 가져와 콘솔에 로깅
		
		for (Car car : repository.findAll()) {
			logger.info(car.getBrand() + " " + car.getModel());
		}
	}

}
