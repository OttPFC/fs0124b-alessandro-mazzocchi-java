package com.progetto.M2_S3_G1.services;

import com.cloudinary.Cloudinary;
import com.progetto.M2_S3_G1.entities.Dipendente;
import com.progetto.M2_S3_G1.exceptions.BadRequestException;
import com.progetto.M2_S3_G1.exceptions.NotFoundException;
import com.progetto.M2_S3_G1.payloads.dipendente.NewDipendenteDTO;
import com.progetto.M2_S3_G1.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DipendenteService {

    @Autowired
    private Cloudinary cloud;

    @Autowired
    private DipendenteRepository dipRep;

    public Dipendente save(NewDipendenteDTO body) throws IOException{
        dipRep.findByEmail(body.email()).ifPresent(user -> {
            throw new BadRequestException("L'email " + body.email() + " è già stata utilizzata");
        });
        Dipendente newDipendente = new Dipendente();
        newDipendente.setUsername(body.username());
        newDipendente.setNome(body.nome());
        newDipendente.setCognome(body.cognome());
        newDipendente.setEmail(body.email());
        newDipendente.setAvatar("http://picsum.photos/200/300");
        return dipRep.save(newDipendente);
    }

    public Page<Dipendente> getDipendenti(int page, int size, String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return dipRep.findAll(pageable);
    }
    public Dipendente findById(int id) {
        return dipRep.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public void delete(int id) {
        Dipendente found = this.findById(id);
        dipRep.delete(found);
    }

    public Dipendente update(int id, Dipendente body){
        Dipendente found = this.findById(id);
        found.setUsername(body.getUsername());
        found.setNome(body.getNome());
        found.setCognome(body.getCognome());
        found.setEmail(body.getEmail());
        return dipRep.save(found);
    }

    public Dipendente uploadImage(int id, MultipartFile file) throws IOException{
        Dipendente found = this.findById(id);
        String url = cloud.uploader().upload(file.getBytes(), null).get("url").toString();
        found.setAvatar(url);
        return dipRep.save(found);
    }

}
