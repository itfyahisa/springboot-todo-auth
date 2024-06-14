package com.todo.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private Long id;
	private String email;
	private String password;
	
	
}
