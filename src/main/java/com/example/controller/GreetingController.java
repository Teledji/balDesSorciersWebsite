package com.example.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.controllerInterface.GreetingControllerInterface;
import com.example.objects.Greeting;

@RestController
@CrossOrigin(origins = "http://localhost:9000") 
public class GreetingController implements GreetingControllerInterface{

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@Override
    public Greeting greeting(String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
