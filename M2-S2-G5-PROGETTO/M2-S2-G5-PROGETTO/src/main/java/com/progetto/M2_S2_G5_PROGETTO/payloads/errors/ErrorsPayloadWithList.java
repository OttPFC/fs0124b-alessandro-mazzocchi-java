package com.progetto.M2_S2_G5_PROGETTO.payloads.errors;

import java.util.Date;
import java.util.List;

public record ErrorsPayloadWithList(
		String message,
		Date timestamp,
		List<String> errorsList
) {
}
