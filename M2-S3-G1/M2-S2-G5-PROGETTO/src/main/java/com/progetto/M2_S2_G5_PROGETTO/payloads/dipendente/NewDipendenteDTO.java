package com.progetto.M2_S2_G5_PROGETTO.payloads.dipendente;

import jakarta.validation.constraints.*;

public record NewDipendenteDTO(
        @NotEmpty(message = "Lo username è obbligatorio")
        @Size(min = 3, max = 30, message = "Lo username deve avere minimo 3 caratteri e massimo 30")
        String username,

        @NotEmpty(message = "Il nome è obbligatorio")
        @Size(min = 2, max = 30, message = "Il nome deve avere minimo 2 caratteri e massimo 30")
        String nome,

        @NotEmpty(message = "Il cognome è obbligatorio")
        @Size(min = 2, max = 30, message = "Il cognome deve avere minimo 2 caratteri e massimo 30")
        String cognome,

        @NotEmpty(message = "L'email è obbligatoria")
        @Email(message = "L'email inserita non è valida")
        String email
) {
}
