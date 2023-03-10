package com.wayne.line.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wayne.line.mongo.model.LineMessageItem;

public interface LineMessageItemRepository extends MongoRepository<LineMessageItem, String>{
	
	public List<LineMessageItem> findByUserId(String userId);

	
}
