package org.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String city;

    public Location() {
    }

    public Location(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location: " +
                "\nid=" + id +
                "\nname='" + name + '\'' +
                "\ncity='" + city + '\'';
    }
}
