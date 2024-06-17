package com.todo.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.todo.app.auth.CustomUserDetails;
import com.todo.app.entity.User;
import com.todo.app.entity.UserForm;
import com.todo.app.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;
	
	public List<User> findAll(){
		return userMapper.findAll();
	}
	
	public User addUser(UserForm userForm) {
		User user = new User();
//		BeanUtils.copyProperties(userForm, user);
		user.setEmail(userForm.getEmail());
		user.setPassword(passwordEncoder.encode(userForm.getPassword()));
		userMapper.insert(user);
		return user;
	}
	
	public Optional<User> getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//セキュリティコンテキストを取得→認証情報取得
		CustomUserDetails customUserDetails = (CustomUserDetails)authentication.getPrincipal();
		//authentication.getPrincipal() 認証されているユーザー情報を取得、ユーザー情報はcustomUserDetailsの型になおす
		return userMapper.findByEmail(customUserDetails.getEmail());
	}
}
