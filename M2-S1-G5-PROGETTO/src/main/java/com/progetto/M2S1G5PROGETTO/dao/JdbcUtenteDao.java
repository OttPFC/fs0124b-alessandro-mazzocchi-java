package com.progetto.M2S1G5PROGETTO.dao;

import com.progetto.M2S1G5PROGETTO.entities.Utente;
import com.progetto.M2S1G5PROGETTO.services.UtenteDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@Slf4j
public class JdbcUtenteDao implements UtenteDao {

    @Autowired
    private JdbcTemplate jdbc;

    private static final String INSERT =
            "INSERT INTO utenti(id,username,nome_completo,email) VALUES(?,?,?,?)";
    private static final String UPDATE =
            "UPDATE utenti SET username = ?, nome_completo = ?, email = ? WHERE id = ?";
    private static final String DELETE =
            "DELETE FROM utenti WHERE id = ?";
    private static final String SELECT_BY_ID =
            "SELECT id, username, nome_completo, email FROM utenti WHERE id = ?";
    private static final String SELECT_ALL =
            "SELECT u FROM utenti u";


    public static class UtenteRowMapper implements RowMapper<Utente>{

        @Override
        public Utente mapRow(ResultSet rs, int rowNum) throws SQLException{
            log.info("Mappando righe dove id = {} e index = {}",rs.getInt("id"),rowNum);
            return Utente.builder()
                    .withUsername(rs.getString("username"))
                    .withNomeCompleto(rs.getString("nomecompleto"))
                    .withEmail(rs.getString("email"))
                    .withId(rs.getInt("id"))
                    .build();
        }
    }




    @Override
    public void insert(Utente u) {
    jdbc.update(INSERT, u.getId(),u.getUsername(),u.getNomeCompleto(),u.getEmail());
    }

    @Override
    public void update(Utente u) {
    jdbc.update(UPDATE, u.getUsername(),u.getNomeCompleto(),u.getEmail());
    }

    @Override
    public void delete(Integer id) {
    jdbc.update(DELETE,id);
    }

    @Override
    public Utente getById(Integer id) {
        return jdbc.queryForObject(SELECT_BY_ID, new UtenteRowMapper(),id);

    }

    @Override
    public List<Utente> getAll() {
        return jdbc.query(SELECT_ALL,new UtenteRowMapper());
    }
}
