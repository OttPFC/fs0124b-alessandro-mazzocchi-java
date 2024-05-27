package com.progetto.M2_S3_G1.controllers;

import com.progetto.M2_S3_G1.entities.Dipendente;
import com.progetto.M2_S3_G1.exceptions.BadRequestException;
import com.progetto.M2_S3_G1.payloads.dipendente.NewDipendenteDTO;
import com.progetto.M2_S3_G1.payloads.dipendente.NewDipendenteResponseDTO;
import com.progetto.M2_S3_G1.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/dipendente")
public class DipendentiController {

    private final DipendenteService dipService;

    @Autowired
    public DipendentiController(DipendenteService dipService) {
        this.dipService = dipService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public NewDipendenteResponseDTO saveDipendente(@RequestBody @Validated NewDipendenteDTO body, BindingResult validation) throws Exception {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }
        Dipendente newDipendente = dipService.save(body);
        return new NewDipendenteResponseDTO(newDipendente.getId());
    }

    @GetMapping("")
    public Page<Dipendente> getDipendenti(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size,
                                          @RequestParam(defaultValue = "id") String sortBy) {
        return dipService.getDipendenti(page, size, sortBy);
    }

    @GetMapping("/{id}")
    public Dipendente getDipendente(@PathVariable int id) throws Exception {
        return dipService.findById(id);
    }

    @PutMapping("/{id}")
    public Dipendente updateDipendente(@PathVariable int id, @RequestBody @Validated Dipendente body, BindingResult validation) throws Exception {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }
        return dipService.update(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        dipService.delete(id);
    }

    @PatchMapping("/{id}/image")
    public Dipendente uploadImage(@RequestParam("image") MultipartFile file, @PathVariable int id) {
        try {
            return dipService.uploadImage(id, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
