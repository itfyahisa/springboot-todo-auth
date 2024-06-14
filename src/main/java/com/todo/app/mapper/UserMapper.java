package com.todo.app.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.todo.app.entity.User;

@Mapper
public interface UserMapper {

	Optional<User> findByEmail(String email);
	List<User> findAll();
	int insert(User user);
}
