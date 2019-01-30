package com.cg.app.RabbitPro.resource;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.RabbitPro.sender.Sender;

@RestController
public class CustomerController {

	@Autowired
	private Sender sender;

	@Bean
	public Queue queue() {
		return new Queue("CustomerQ", false);
	}

	@RequestMapping
	public String send() {

		sender.send("message sent");
		return "Sent";

	}

}
