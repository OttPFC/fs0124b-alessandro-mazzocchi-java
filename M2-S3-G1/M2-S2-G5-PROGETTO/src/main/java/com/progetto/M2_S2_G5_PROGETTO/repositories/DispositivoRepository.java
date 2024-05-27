package com.progetto.M2_S2_G5_PROGETTO.repositories;

import com.progetto.M2_S2_G5_PROGETTO.entities.Dipendente;
import com.progetto.M2_S2_G5_PROGETTO.entities.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo,Integer> {

    List<Dispositivo> findByDipendente(Dipendente dipendente);
}
