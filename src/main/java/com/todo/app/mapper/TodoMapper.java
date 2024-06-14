package com.todo.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.todo.app.entity.Todo;

@Mapper
public interface TodoMapper {

	List<Todo> findAll();
	Todo findById(Long id);
	int insert(Todo todo);
	int update(Todo todo);
	int delete(Long id);
	
}
