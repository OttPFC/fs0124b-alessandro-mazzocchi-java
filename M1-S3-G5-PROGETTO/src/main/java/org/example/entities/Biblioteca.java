package org.example.entities;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "biblioteca")
@Inheritance(strategy = InheritanceType.JOINED)
@AttributeOverride(name = "id", column = @Column(name = "biblioteca_id"))
//@NamedQuery(name = "find_by_isbn", query = "SELECT b FROM biblioteca b WHERE isbn=:isbn")
public abstract class Biblioteca extends BaseEntity{

    protected long isbn;
    protected String titolo;
    //@Column(name = "anno_pubblicazione")
    protected int annoPublicazione;
    protected int pagine;

    @OneToMany(mappedBy="biblioteca")
    private List<Prestito> prestiti;


    public Biblioteca(long isbn, String titolo, int annoPublicazione, int pagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPublicazione = annoPublicazione;
        this.pagine = pagine;
    }
    public Biblioteca() {
    }


    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPublicazione() {
        return annoPublicazione;
    }

    public void setAnnoPublicazione(int annoPubblicazione) {
        this.annoPublicazione = annoPublicazione;
    }

    public int getPagine() {
        return pagine;
    }

    public void setPagine(int pagine) {
        this.pagine = pagine;
    }

    @Override
    public String toString() {
        return String.format("LibraryItem [isbn=%s, titolo=%s, annoPublicazione=%s, pagine=%s, id=%s]",
                isbn, titolo, annoPublicazione, pagine, getId());
    }
}


