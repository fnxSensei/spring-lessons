package com.itmo.springproject01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@EntityScan для поиска entity классов вне текущего пакета

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

// @EntityScan для поиска entity классов вне текущего пакета
@SpringBootApplication
public class SpringProject01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringProject01Application.class, args);
	}

}
