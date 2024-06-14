package com.todo.app.exception;

public class TodoNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public TodoNotFoundException(Long id) {
        super("Todo : " + id + " が見つかりません");
    }
	
}
