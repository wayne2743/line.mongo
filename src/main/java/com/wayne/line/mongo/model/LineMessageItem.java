package com.wayne.line.mongo.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("LineMessageItem")
public class LineMessageItem {
	
	@Id
	private String id;
	
	private String userId;
	private String userMessage;
	private Long timestamp;
	
	public LineMessageItem(String userId, String userMessage, Long timestamp) {
		super();
		this.id = UUID.randomUUID().toString();
		this.userId = userId;
		this.userMessage = userMessage;
		this.timestamp = timestamp;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
