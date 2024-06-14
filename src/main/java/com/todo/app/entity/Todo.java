package com.todo.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
	
	private Long id;
	private String title;
	private String status; 
	private String details;

}
