package com.ulearn.ulearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URLClassLoader;

@SpringBootApplication
public class UlearnApplication {

	public static void main(String[] args) {
		Thread.currentThread().setContextClassLoader(URLClassLoader.getSystemClassLoader());
		SpringApplication.run(UlearnApplication.class, args);
	}
}
