package com.anudip.sms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleUserNotFoundException(StudentNotFoundException ex,
			WebRequest request){
		ErrorMessage errorMessage= new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
	}
	
	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleUserNotFoundException(CourseNotFoundException ex,
			WebRequest request){
		ErrorMessage errorMessage= new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
	}
	
}
