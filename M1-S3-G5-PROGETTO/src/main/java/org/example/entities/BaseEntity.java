package org.example.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    protected long id;

    private Date insertedAt = new Date();

    public BaseEntity() {
    }

    public long getId() {
        return id;
    }

    public Date getInsertedAt() {
        return insertedAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setInsertedAt(Date insertedAt) {
        this.insertedAt = insertedAt;
    }
}
