package com.todo.app.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne //多対1
	@JoinColumn(name = "user_id") //FKを管理する、SQLでのカラム名
	private Long userId;
	
}
