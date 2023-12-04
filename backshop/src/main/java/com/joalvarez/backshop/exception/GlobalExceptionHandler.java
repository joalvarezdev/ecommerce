package com.joalvarez.backshop.exception;

import com.joalvarez.baseframework.utils.HasLogger;
import com.joalvarez.baseframework.data.dto.ResponseDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler implements HasLogger{


	@ExceptionHandler(PersistenceException.class)
	public ResponseEntity<ResponseDTO> handler(PersistenceException ex) {
		final ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setCode(InternalCode.ENTITY_NOT_FOUND.code());
		responseDTO.setMessage(InternalCode.ENTITY_NOT_FOUND.message());
		responseDTO.setDetails(List.of(ex.getMessage()));
		return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ResponseDTO> handler(EntityNotFoundException ex) {
		final ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setCode(InternalCode.ENTITY_NOT_FOUND.code());
		responseDTO.setMessage(InternalCode.ENTITY_NOT_FOUND.message());
		responseDTO.setDetails(List.of(ex.getMessage()));
		return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(GenericException.class)
	public ResponseEntity<ResponseDTO> handler(GenericException ex) {
		StringBuilder message = new StringBuilder("Error: ");
		message
			.append(ex.getHttpStatus().toString())
			.append(": ").append(ex.getInternalCode().message())
			.append(": ").append(ex.getMessage());
		final ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setCode(ex.getInternalCode().code());
		responseDTO.setMessage(ex.getInternalCode().message());
		responseDTO.setDetails(List.of(ex.getMessage()));

		return new ResponseEntity<>(responseDTO, ex.getHttpStatus());
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handler(HttpMessageNotReadableException ex) {
/*
		StringBuilder message = new StringBuilder("Error: ");
		message
			.append(ex.getHttpStatus().toString())
			.append(": ").append(ex.getInternalCode().message())
			.append(": ").append(ex.getMessage());
*/
		final ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setCode(23);
		responseDTO.setMessage(ex.getMessage());
		responseDTO.setDetails(List.of(ex.getStackTrace().toString()));

		return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
	}
}