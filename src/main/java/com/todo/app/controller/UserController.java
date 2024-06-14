package com.todo.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.app.entity.User;
import com.todo.app.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@GetMapping
	public List<User> userList(){
		return userService.findAll();
	}
	
}
