package com.chatapp.web.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.chatapp.web.Greeting;
import com.chatapp.web.Message;

@Controller
public class MessageController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(Message message) {
		try {
		Thread.sleep(500);
		}catch (Exception ex) {
			System.out.println(ex);
		}
		return new Greeting("hello " + HtmlUtils.htmlEscape(message.getName())  + "!");
	}
	
}
