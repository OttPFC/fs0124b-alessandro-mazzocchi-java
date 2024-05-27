package com.progetto.M2_S3_G1.payloads;

import com.progetto.M2_S3_G1.entities.Stato;
import jakarta.validation.constraints.NotNull;

public record NewDispositivoPayload(
        @NotNull(message = "Il nome del dispositivo va specificato")
        String nome,
        @NotNull(message = "Il tipo di dispositivo va specificato")
        String tipo,
        @NotNull(message = "Lo stato del dispositivo va specificato")
        Stato stato,
        @NotNull(message = "Inserire l'id del dipendente a cui assegnare il dispositivo")
        Integer id
) {
}
