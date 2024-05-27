package com.progetto.M2_S2_G5_PROGETTO.controllers;

import com.progetto.M2_S2_G5_PROGETTO.entities.Dispositivo;
import com.progetto.M2_S2_G5_PROGETTO.exceptions.BadRequestException;
import com.progetto.M2_S2_G5_PROGETTO.payloads.NewDispositivoPayload;
import com.progetto.M2_S2_G5_PROGETTO.services.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispositivo")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Dispositivo saveDispositivo(@RequestBody @Validated NewDispositivoPayload body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }
        return dispositivoService.save(body);
    }

    @GetMapping("")
    public List<Dispositivo> getDispositivi(@RequestParam(required = false) Integer id) {
        if (id != null) {
            return dispositivoService.findByDipendente(id);
        } else {
            return dispositivoService.getDispositivi();
        }
    }

    @GetMapping("/{id}")
    public Dispositivo findById(@PathVariable int id) {
        return dispositivoService.findById(id);
    }

    @PutMapping("/{id}")
    public Dispositivo updateDispositivo(@PathVariable int id, @RequestBody @Validated NewDispositivoPayload body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }
        return dispositivoService.update(id, body);
    }

    @DeleteMapping("/{id}")
    public void deleteDispositivo(@PathVariable int id) {
        dispositivoService.delete(id);
    }
//    @PutMapping("/{dispositivoId}/assegna/{dipendenteId}")
//    public Dispositivo assegnaDispositivo(@PathVariable Long dispositivoId, @PathVariable Long dipendenteId) {
//        return dispositivoService.assegnaDispositivo(dispositivoId, dipendenteId);
//    }
}
