package com.wayne.line.mongo.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;
import com.wayne.line.mongo.service.LineMessageItemService;
import com.wayne.line.mongo.utils.LineBotClient;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import sun.util.logging.resources.logging;

@RestController
@RequestMapping("/line/mongo/message")
public class LineMongoController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	LineMessageItemService lineMessageItemService;
	
	@Autowired
	LineBotClient lineBotClient;

	@GetMapping(value = "/send")
	@Operation(summary = "Push Message Back to Line")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Message Send OK!", 
					content = {@Content(mediaType = MediaType.TEXT_PLAIN_VALUE)})
	})
	public String sendMessageBackToLine(@RequestParam(required = true) String sendMessages, @RequestParam(required = true) String userId) { //		        "U93f0c12e0a2aeabdf6309aa70d2f95da"
		
		BotApiResponse botApiResponse = lineBotClient.callLineBot(sendMessages, userId);
		
		return botApiResponse.getMessage();
	}


	@GetMapping(value = "/list")
	@Operation(summary = "List the ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Message query successfully!")
	})
	public List<String> listUserMessages(@RequestParam(required = true) String userId) {
		return lineMessageItemService.findAllByUserId(userId).stream()
				.map(v -> v.getUserMessage())
				.collect(Collectors.toList());
	}

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
    	logger.error(e.getMessage());
		return "Failed!";
    }
}
