package com.todo.app.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=UniqueEmailValidator.class)

public @interface UniqueEmail {

	String message() default "入力されたメールアドレスは既に登録されています。別のメールアドレスを入力してください。";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
	
}
