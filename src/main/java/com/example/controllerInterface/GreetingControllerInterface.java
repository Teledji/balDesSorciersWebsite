package com.example.controllerInterface;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.objects.Greeting;

public interface GreetingControllerInterface {

	/*
	 * Return a hello salutation with the name in parameter
	 * @Param : name - required
	 * 		The name to show
	 */
	@GetMapping("/greeting")
    public Greeting greeting(@RequestParam(required=true)String name);
}
