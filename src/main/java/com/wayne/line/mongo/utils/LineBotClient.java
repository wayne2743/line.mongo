package com.wayne.line.mongo.utils;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;

@Component
public class LineBotClient {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${line.bot.channel-token}")
	String lineChannelAPIKey;

	public BotApiResponse callLineBot(String sendMessages, String userId) {
		final LineMessagingClient client = LineMessagingClient
		        .builder(lineChannelAPIKey)
		        .build();
		
		final TextMessage textMessage = new TextMessage(sendMessages);
		final PushMessage pushMessage = new PushMessage(
				userId,
		        textMessage);
		
		final BotApiResponse botApiResponse;
		try {
			
		    botApiResponse = client.pushMessage(pushMessage).get();
		} catch (InterruptedException | ExecutionException e) {
		    e.printStackTrace();
		    return null;
		}

		logger.info(String.format("botApiResponse: %s", botApiResponse.toString()));
		
		return botApiResponse;
	}
}
