package com.wayne.line.mongo.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import com.wayne.line.mongo.model.LineMessageItem;
import com.wayne.line.mongo.service.LineMessageItemService;

@LineMessageHandler
@Component
public class ExternalMessageHandler {

	@Autowired
	LineMessageItemService lineMessageItemService;

	@EventMapping
	public void handleTextMessageEvent(MessageEvent<TextMessageContent> event) {

		System.out.println("event: " + event);
		lineMessageItemService.create(new LineMessageItem(event.getSource().getUserId(), event.getMessage().getText(),
				event.getTimestamp().toEpochMilli()));
		
	}

	@EventMapping
	public void handleDefaultMessageEvent(Event event) {

		System.out.println("event: " + event);
	}
}
