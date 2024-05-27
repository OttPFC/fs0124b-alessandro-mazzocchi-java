package com.progetto.M2_S3_G1.repositories;

import com.progetto.M2_S3_G1.entities.Dipendente;
import com.progetto.M2_S3_G1.entities.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo,Integer> {

    List<Dispositivo> findByDipendente(Dipendente dipendente);
}
