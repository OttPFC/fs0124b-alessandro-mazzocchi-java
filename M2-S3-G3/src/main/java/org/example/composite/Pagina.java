package org.example.composite;

public class Pagina extends BaseEntity {

    private int numeroDiPagina;
    private String contenuto;

    public Pagina(int numeroDiPagina, String contenuto) {
        this.numeroDiPagina = numeroDiPagina;
        this.contenuto = contenuto;
    }
    public int getNumeroDiPagina() {
        return numeroDiPagina;
    }
    public void setNumeroDiPagina(int numeroDiPagina) {
        this.numeroDiPagina = numeroDiPagina;
    }
    public String getContenuto() {
        return contenuto;
    }
    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    @Override
    public int getNumeroPagine() {
        return 1;
    }

    @Override
    public void stampa() {
        System.out.println("Numero di pagina " + this.numeroDiPagina);
        System.out.println(this.contenuto);
    }
}
