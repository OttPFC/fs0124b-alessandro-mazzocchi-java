package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entities.Location;

public class LocationDAO {

    private EntityManager em;

    public LocationDAO(EntityManager em) {this.em = em;}

    public void saveLocation(Location location){
        try{
            em.getTransaction().begin();
            em.persist(location);
            em.getTransaction().commit();
            System.out.println(location.getName() + " salvato correttamente");
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Location getLocation(String name) throws ClassNotFoundException {return em.find(Location.class,name);}

    public void deleteLocation(String name) throws ClassNotFoundException {
        Location location = getLocation(name);
        try{
            em.getTransaction().begin();
            em.remove(location);
            em.getTransaction().commit();
            System.out.println(location.getName() + " eliminato correttamente");
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    };


}
