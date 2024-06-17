package com.todo.app.validation;

import com.todo.app.mapper.UserMapper;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String>{
//	アノテーション(UniqueEmail), String(email)
	
	private final UserMapper userMapper;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return userMapper.findByEmail(value).isEmpty();
	}
	
}
