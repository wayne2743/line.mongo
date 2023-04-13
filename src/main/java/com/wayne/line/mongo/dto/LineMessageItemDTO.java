package com.wayne.line.mongo.dto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.wayne.line.mongo.model.LineMessageItem;
import com.wayne.line.mongo.repository.LineMessageItemRepository;

@Configuration
@Component
public class LineMessageItemDTO {
	
	@Autowired
	LineMessageItemRepository lineMessageItemRepository;
	
	public LineMessageItem create(LineMessageItem lineMessageItem) {
		return lineMessageItemRepository.insert(lineMessageItem);		
	}
	
	public LineMessageItem update(LineMessageItem lineMessageItem) {
		return lineMessageItemRepository.save(lineMessageItem);
	}
	
	public Optional<LineMessageItem> find(String id) {
		return lineMessageItemRepository.findById(id);
	}
	
	public List<LineMessageItem> findAllByUserId(String userId) {
		return lineMessageItemRepository.findByUserId(userId);
	}
}
