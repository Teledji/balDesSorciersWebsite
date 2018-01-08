package com.balds.controllerInterface;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.balds.objects.Email;

public interface EmailControllerInterface {
	
	@PostMapping("/email")
	public @ResponseBody boolean sendEmailWebService(@RequestBody Email email) throws Exception;
}
