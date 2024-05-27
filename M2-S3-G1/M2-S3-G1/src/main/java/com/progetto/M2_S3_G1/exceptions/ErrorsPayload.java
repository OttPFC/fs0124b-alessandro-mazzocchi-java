package com.progetto.M2_S3_G1.exceptions;

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