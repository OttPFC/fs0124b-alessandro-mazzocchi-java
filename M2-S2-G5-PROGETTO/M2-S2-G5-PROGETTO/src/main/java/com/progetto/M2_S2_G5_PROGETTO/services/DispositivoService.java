package com.progetto.M2_S2_G5_PROGETTO.services;

import com.progetto.M2_S2_G5_PROGETTO.entities.Dipendente;
import com.progetto.M2_S2_G5_PROGETTO.entities.Dispositivo;
import com.progetto.M2_S2_G5_PROGETTO.exceptions.NotFoundException;
import com.progetto.M2_S2_G5_PROGETTO.payloads.NewDispositivoPayload;
import com.progetto.M2_S2_G5_PROGETTO.repositories.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispositivoService {

    @Autowired
    DispositivoRepository disRep;

    @Autowired
    private DipendenteService dipServ;

    public Dispositivo save(NewDispositivoPayload body) {
        Dipendente dipendente = dipServ.findById(body.id());
        Dispositivo disp = new Dispositivo();
        disp.setNome(body.nome());
        disp.setTipo(body.tipo());
        disp.setStato(body.stato());
        disp.setDipendente(dipendente);
        disp.setImage("http://picsum.photos/200/300");
        return disRep.save(disp);
    }

    public List<Dispositivo> getDispositivi() {
        return disRep.findAll();
    }

    public Dispositivo findById(int id) {
        return disRep.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void delete(int id) {
        Dispositivo dis = this.findById(id);
        disRep.delete(dis);
    }

    public Dispositivo update(int id, NewDispositivoPayload body){
        Dispositivo found = this.findById(id);

        found.setNome(body.nome());
        found.setStato(body.stato());
        if(found.getDipendente().getId() != body.id()){
            Dipendente dipendente = dipServ.findById(body.id());
            found.setDipendente(dipendente);
        }
        return disRep.save(found);
    }

    public List<Dispositivo> findByDipendente(int id){
        Dipendente dipendente = dipServ.findById(id);
        return disRep.findByDipendente(dipendente);
    }
}
