package com.nvrsk.controller;

import com.nvrsk.model.Message;
import com.nvrsk.model.ProcessedMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
public class MessageController {

	@MessageMapping("/chat")
	@SendTo("/topic/broadcast")
	public ProcessedMessage processMessage(@Payload Message message) throws Exception {
		Thread.sleep(1000); // simulated delay
		String date = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		return new ProcessedMessage(date + ": " + message.getBody());
	}

}
