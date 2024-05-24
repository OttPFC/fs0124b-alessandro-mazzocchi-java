package com.progetto.M2_S2_G5_PROGETTO.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ErrorsPayload {
	private String message;
	private LocalDateTime timestamp;
}