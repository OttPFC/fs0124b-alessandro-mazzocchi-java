package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entities.Persona;

public class PersonaDAO {

    private EntityManager em;

    public PersonaDAO(EntityManager em) {this.em = em;}

    public void save(Persona persona) {
        try{
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Persona getPersona(String name){return em.find(Persona.class, name);}

    public void deletePersona(long id){

        Persona persona = em.find(Persona.class, id);
        try{
            em.getTransaction().begin();
            em.remove(persona);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
