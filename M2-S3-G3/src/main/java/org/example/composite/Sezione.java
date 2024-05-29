package org.example.composite;

import java.util.List;

public class Sezione extends BaseEntity {
    private List<BaseEntity> componenti;
    private String nomeSezione;

    public Sezione(String nomeSezione, List<BaseEntity> componenti){
        this.nomeSezione = nomeSezione;
        this.componenti = componenti;
    }
    @Override
    public int getNumeroPagine() {
        return this.componenti.stream().mapToInt(BaseEntity::getNumeroPagine).sum();
    }

    @Override
    public void stampa() {
        System.out.println(this.nomeSezione.toUpperCase());
        this.componenti.forEach(BaseEntity::stampa);
    }
}
