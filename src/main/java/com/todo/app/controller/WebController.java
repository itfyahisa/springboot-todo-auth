package com.todo.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.todo.app.dto.TodoRequest;
import com.todo.app.dto.TodoResponse;
import com.todo.app.entity.UserForm;
import com.todo.app.service.TodoService;
import com.todo.app.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class WebController {
	
	private final UserService userService;
	private final TodoService todoService;
	
	@GetMapping("/")
	public String local() {
		return "top";
	}
	
	@GetMapping("/top")
	public String top() {
		return "top";
	}
	
	@GetMapping("user/login")
	public String lginForm() {
		return "user/login";
	}
	
	@GetMapping("user/logout")
	public String LogoutForm() {
		return "user/logout";
	}
	
	@GetMapping("/users")
	public String index(Model model) {
		model.addAttribute("userList", userService.findAll());
		return "user/index";
	}
	
	@GetMapping("/user/register")
	public String createForm(@ModelAttribute UserForm userForm) {
		return "user/register";
	}
	
	@PostMapping("/user/register")
	public String register(@Validated UserForm userForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "user/register";
		}else {
			userService.addUser(userForm);
			return "redirect:/user/login";
		}
	}
	
	@GetMapping("/todos")
	public String getAllTodos(Model model, TodoRequest todoRequest) {
		List<TodoResponse> todos = todoService.getAllTodo();
		model.addAttribute("todos", todos);
		model.addAttribute("todoRequest", new TodoRequest());
		return "todo/index";
	}
	
	@PostMapping("/todos")
	public String addTodo(Model model, TodoRequest todoRequest) {
		todoService.addTodo(todoRequest);
		List<TodoResponse> todos = todoService.getAllTodo();
		model.addAttribute("todos", todos);
		return "todo/index";
	}
	
	@GetMapping("/todos/{id}")
	public String getTodo(@PathVariable("id") Long id, Model model) {
		TodoResponse todo = todoService.getTodo(id);
		model.addAttribute("todo", todo);
		model.addAttribute("todoRequest", new TodoRequest());
		return "todo/show";
	}
	
	@PostMapping("/todos/{id}")
	public String updateTodo(@PathVariable("id") Long id, TodoRequest todoRequest, Model model) {
		todoService.updateTodo(id, todoRequest);
		TodoResponse todo = todoService.getTodo(id);
		model.addAttribute("todo", todo);
		return "todo/show";
	}
	
	@DeleteMapping("/todos/{id}")
	public String deleteTodo(@PathVariable("id") Long id) {
		todoService.deleteTodo(id);
		return "/todo/index";
	}
	
	
}
