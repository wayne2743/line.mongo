package com.wayne.line.mongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wayne.line.mongo.dto.LineMessageItemDTO;
import com.wayne.line.mongo.model.LineMessageItem;
import com.wayne.line.mongo.repository.LineMessageItemRepository;

@Service
public class LineMessageItemService {
	
	@Autowired
	LineMessageItemDTO lineMessageItemDTO;
	
	public LineMessageItem create(LineMessageItem lineMessageItem) {
		return lineMessageItemDTO.create(lineMessageItem);		
	}
	
	public LineMessageItem update(LineMessageItem lineMessageItem) {
		return lineMessageItemDTO.update(lineMessageItem);
	}
	
	public Optional<LineMessageItem> find(String id) {
		return lineMessageItemDTO.find(id);
	}
	
	public List<LineMessageItem> findAllByUserId(String userId) {
		return lineMessageItemDTO.findAllByUserId(userId);
	}
}
