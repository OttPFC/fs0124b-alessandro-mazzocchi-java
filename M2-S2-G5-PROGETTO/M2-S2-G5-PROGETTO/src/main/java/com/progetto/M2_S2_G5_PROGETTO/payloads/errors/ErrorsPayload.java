package com.progetto.M2_S2_G5_PROGETTO.payloads.errors;

import java.util.Date;

public record ErrorsPayload(
		String message,
		Date timestamp) {
	public ErrorsPayload(String message, Date timestamp) {
		this.message = message;
		this.timestamp = timestamp;
	}
}