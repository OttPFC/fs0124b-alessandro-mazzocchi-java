package com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.exceptions;


import com.gestioneeventi.M2_S3_G5_PROGETTO.businesslayer.services.dto.DtoBase;

public class PersistEntityException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public final DtoBase invalidDto;

	public PersistEntityException(DtoBase invalidDto) {
		this.invalidDto = invalidDto;
	}
}
