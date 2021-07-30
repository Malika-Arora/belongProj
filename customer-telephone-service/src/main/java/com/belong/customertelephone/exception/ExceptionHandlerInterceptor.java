package com.belong.customertelephone.exception;

import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;
@ControllerAdvice
@Slf4j
public class ExceptionHandlerInterceptor extends ResponseEntityExceptionHandler {



	@ExceptionHandler
	public ResponseEntity<Object> handleCustomBadRequest(final CustomBadRequestException e) {
		log.debug(e.getLocalizedMessage(), e);
		String errorMessage = replaceEmptyExceptionMessage(e.getLocalizedMessage());
		return ResponseEntity.badRequest().body(errorMessage);
	}

	@ExceptionHandler
	public ResponseEntity<Object> handleCustomUnauthorised(final CustomUnauthorisedException e) {
		log.debug(e.getLocalizedMessage(), e);
		String errorMessage = replaceEmptyExceptionMessage(e.getLocalizedMessage());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
	}

	@ExceptionHandler
	public ResponseEntity<Object> handleCustomNotFound(final CustomNotFoundException e) {
		log.debug(e.getLocalizedMessage(), e);
		String errorMessage = replaceEmptyExceptionMessage(e.getLocalizedMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
	}


	@ExceptionHandler
	public ResponseEntity<Object> handleCustomInternalServer(final CustomInternalServerException e) {
		log.debug(e.getLocalizedMessage(), e);
		String errorMessage = replaceEmptyExceptionMessage(e.getLocalizedMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(
			Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		if (body == null || body == Strings.EMPTY) {
			return super.handleExceptionInternal(ex, ex.getLocalizedMessage(), headers, status, request);
		}

		return super.handleExceptionInternal(ex, body, headers, status, request);
	}

	private String replaceEmptyExceptionMessage(String message) {
		if (message == null || message.isEmpty()) {
			return "Unidentified exception.";
		}

		return message;
	}
}