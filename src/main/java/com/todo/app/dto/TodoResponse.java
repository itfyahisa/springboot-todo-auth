package com.todo.app.dto;

import com.todo.app.entity.Todo;
import lombok.Data;

@Data
public class TodoResponse {
 
	private Long id;
	private Long userId;
	private String title;
	private String status; 
	private String details;
	
	public TodoResponse(Todo todo) {
		this.id = todo.getId();
		this.userId = todo.getUserId();
		this.title = todo.getTitle();
		this.status = todo.getStatus();
		this.details = todo.getDetails();
	}
	
}
