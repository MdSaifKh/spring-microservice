package com.mind.student.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "message-service", url = "${message_service_url}")
public interface MessageFeignClient {
	
	@GetMapping("/greeting")
	public String say_greet();

}
