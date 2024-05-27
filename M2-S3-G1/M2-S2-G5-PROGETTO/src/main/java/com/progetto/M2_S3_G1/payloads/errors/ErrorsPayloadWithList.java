package com.progetto.M2_S3_G1.payloads.errors;

import java.util.Date;
import java.util.List;

public record ErrorsPayloadWithList(
		String message,
		Date timestamp,
		List<String> errorsList
) {
}
