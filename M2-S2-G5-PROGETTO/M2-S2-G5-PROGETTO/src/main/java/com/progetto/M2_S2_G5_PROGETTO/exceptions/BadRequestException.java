package com.progetto.M2_S2_G5_PROGETTO.exceptions;

import lombok.Getter;
import org.springframework.validation.ObjectError;

import java.util.List;

@Getter
public class BadRequestException extends RuntimeException {
	private List<ObjectError> errorsList;

	public BadRequestException(String message) {
		super(message);
	}

	public BadRequestException(List<ObjectError> errorsList) {
		super("Errori nel body");
		this.errorsList = errorsList;
	}

}