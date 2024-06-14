package com.todo.app.entity;

import com.todo.app.validation.UniqueEmail;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
	
	@NotBlank
	@UniqueEmail
	private String email;
	
	@NotBlank
	@Size(min=7, max=128)
	private String password;

}
