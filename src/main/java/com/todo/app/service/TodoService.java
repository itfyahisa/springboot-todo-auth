package com.todo.app.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.app.dto.TodoRequest;
import com.todo.app.dto.TodoResponse;
import com.todo.app.entity.Todo;
import com.todo.app.entity.User;
import com.todo.app.exception.TodoNotFoundException;
import com.todo.app.mapper.TodoMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {

//	@Autowired
	private final TodoMapper todoMapper;
	private final UserService userService;
	
	public List<TodoResponse> getAllTodo(){
		List<Todo> todoList = todoMapper.findAll();
//		DTOで転送したい
		List<TodoResponse> todoResponses = new ArrayList<>();
//		for(Todo todo : todos) {
//			TodoResponse todoResponse = new TodoResponse(todo);
//			todoResponses.add(todoResponse);
//		}
//		ラムダ式でも書けるけど拡張for文のほうがわかりやすい気がする
		todoList.forEach(todo -> {
			TodoResponse todoResponse = new TodoResponse(todo);
			todoResponses.add(todoResponse);
					});
		return todoResponses;
	}
	
	public TodoResponse getTodo(Long id) {
		Todo todo = findTodoOrThrow(id);
		TodoResponse todoResponse = new TodoResponse(todo);
		return todoResponse;
	}
	
	public TodoResponse addTodo(TodoRequest todoRequest) {
		Todo todo = new Todo();
		BeanUtils.copyProperties(todoRequest, todo);
		User currentUser = userService.getCurrentUser().orElseThrow();
		todo.setUserId(currentUser.getId());
		todoMapper.insert(todo);
		TodoResponse todoResponse = new TodoResponse(todo);
		return todoResponse;
	}
	
	public TodoResponse updateTodo(Long id, TodoRequest todoRequest) {
		Todo todo = findTodoOrThrow(id);
		BeanUtils.copyProperties(todoRequest, todo);
		todoMapper.update(todo);
		TodoResponse todoResponse = new TodoResponse(todo);
		return todoResponse;
	}
	
	public void deleteTodo(Long id) {
		findTodoOrThrow(id);
		todoMapper.delete(id);
	}
	
	
//	idが対応するtodoがnullかどうか判別する
	private Todo findTodoOrThrow(Long id) {
		Todo todo  = todoMapper.findById(id);
		if(todo == null) {
			throw new TodoNotFoundException(id);
		}
		return todo;
	}
	
}
