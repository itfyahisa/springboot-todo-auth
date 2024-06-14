package com.todo.app.controller;

//import java.util.ArrayList;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.app.dto.TodoRequest;
import com.todo.app.dto.TodoResponse;
import com.todo.app.service.TodoService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("rest/todos")
@RequiredArgsConstructor
public class TodoController {
	
//	@Autowired
	private final TodoService todoService;
	
	@GetMapping
	public List<TodoResponse> getAllTodos() {
		return todoService.getAllTodo();
	}
	
	@GetMapping("/{id}")
	public TodoResponse getTodo(@PathVariable("id") Long id) {
		return todoService.getTodo(id);
	}
	
	@PostMapping
	public TodoResponse addTodo(@RequestBody TodoRequest todoRequest) {
		return todoService.addTodo(todoRequest);
	}
	
	@PutMapping("/{id}")
	public TodoResponse updateTodo(@PathVariable("id") Long id, @RequestBody TodoRequest todoRequest) {
		return todoService.updateTodo(id, todoRequest);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable("id") Long id) {
		todoService.deleteTodo(id);
	}
		
}
