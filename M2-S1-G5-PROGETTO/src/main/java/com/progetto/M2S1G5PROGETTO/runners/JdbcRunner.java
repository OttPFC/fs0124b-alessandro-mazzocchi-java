package com.progetto.M2S1G5PROGETTO.runners;
import com.github.javafaker.Faker;
import com.progetto.M2S1G5PROGETTO.entities.*;
import com.progetto.M2S1G5PROGETTO.entities.Prenotazioni;
import com.progetto.M2S1G5PROGETTO.services.EdificioDao;
import com.progetto.M2S1G5PROGETTO.services.PostazioneDao;
import com.progetto.M2S1G5PROGETTO.services.PrenotazioniDao;
import com.progetto.M2S1G5PROGETTO.services.UtenteDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Slf4j
public class JdbcRunner implements CommandLineRunner {

    @Autowired
    private UtenteDao uDao;

    @Autowired
    private EdificioDao eDao;

    @Autowired
    private PostazioneDao pDao;

    @Autowired
    private PrenotazioniDao prenotazioneDao;

    @Override
    public void run(String... args) throws Exception {
        try {
            List<Utente> utenti = createUtenti(10);
            for (Utente utente : utenti) {
                uDao.insert(utente);
            }
            List<Edificio> edifici = createEdifici(4);
            for (Edificio edificio : edifici) {
                eDao.insert(edificio);
            }
            List<Postazione> postazioni = createPostazioni(10, edifici, utenti);
            for (Postazione postazione : postazioni) {
                pDao.insert(postazione);
            }
            List<Prenotazioni> prenotazioniEsistenti = prenotazioneDao.getAll();
            List<Prenotazioni> prenotazioni = createPrenotazioni(10, edifici, utenti, postazioni, prenotazioniEsistenti);
            for (Prenotazioni prenotazione : prenotazioni) {
                prenotazioneDao.insert(prenotazione);
            }

        } catch (Exception e) {
            log.error("Errore durante l'inserimento delle prenotazioni nel database: {}", e.getMessage());
            throw e;
        }

    }

    public static List<Utente> createUtenti(int quantity) {
        List<Utente> utenti = new ArrayList<>();
        Faker faker = new Faker();

        for (int i = 0; i < quantity; i++) {
            Utente utente = Utente.builder()
                    .withUsername(faker.name().username())
                    .withNomeCompleto(faker.name().fullName())
                    .withEmail(faker.internet().emailAddress())
                    .build();
            utenti.add(utente);
        }

        return utenti;
    }

    public static List<Edificio> createEdifici(int quantity) {
        List<Edificio> edifici = new ArrayList<>();
        Faker faker = new Faker();

        for (int i = 0; i < quantity; i++) {
            Edificio edificio = Edificio.builder()
                    .withNome(faker.company().name())
                    .withIndirizzo(faker.address().streetAddress())
                    .withCitta(faker.address().city())
                    .build();
            edifici.add(edificio);
        }

        return edifici;
    }

    public static List<Postazione> createPostazioni(int quantity, List<Edificio> edifici, List<Utente> utenti) {
        List<Postazione> postazioni = new ArrayList<>();
        Faker faker = new Faker();
        Set<Utente> utentiAssegnati = new HashSet<>();
        for (int i = 0; i < quantity; i++) {
            Utente utente;
            do {
                utente = utenti.get(faker.random().nextInt(utenti.size()));
            } while (utentiAssegnati.contains(utente));
            utentiAssegnati.add(utente);
            Edificio edificio = edifici.get(faker.random().nextInt(edifici.size()));
            Postazione postazione = Postazione.builder()
                    .withCodiceUnivoco(faker.number().randomNumber())
                    .withDescrizione(faker.lorem().sentence())
                    .withTipo(Tipo.values()[faker.random().nextInt(Tipo.values().length)])
                    .withMaxPax(faker.number().numberBetween(1, 10))
                    .withEdificio(edificio)
                    .build();
            postazioni.add(postazione);
        }
        return postazioni;
    }

    public static List<Prenotazioni> createPrenotazioni(int quantity, List<Edificio> edifici, List<Utente> utenti, List<Postazione> postazioni, List<Prenotazioni> prenotazioniEsistenti) {
        List<Prenotazioni> prenotazioni = new ArrayList<>();
        Faker faker = new Faker();
        Set<Integer> utentiIds = new HashSet<>();
        Set<Integer> postazioniIds = new HashSet<>();

        Set<Integer> postazioniPrenotate = prenotazioniEsistenti.stream()
                .map(prenotazione -> prenotazione.getPostazione().getId())
                .collect(Collectors.toSet());

        for (int i = 0; i < quantity; i++) {
            Edificio edificio = edifici.get(faker.random().nextInt(edifici.size()));
            Utente utente;
            Postazione postazione;

            do {
                utente = utenti.get(faker.random().nextInt(utenti.size()));
            } while (utentiIds.contains(utente.getId()));

            do {
                postazione = postazioni.get(faker.random().nextInt(postazioni.size()));
            } while (postazioniIds.contains(postazione.getId()) || postazioniPrenotate.contains(postazione.getId()));

            utentiIds.add(utente.getId());
            postazioniIds.add(postazione.getId());

            Prenotazioni prenotazione = new Prenotazioni();
            prenotazione.setGiornoPrenotazione(LocalDate.now());
            prenotazione.setGiornoPrenotato(LocalDate.now().plusDays(faker.random().nextInt(30)));
            prenotazione.setEdificio(edificio);
            prenotazione.setUtente(utente);
            prenotazione.setPostazione(postazione);
            prenotazione.calcolaGiornoScadenza();
            prenotazioni.add(prenotazione);
        }
        return prenotazioni;
    }
}
