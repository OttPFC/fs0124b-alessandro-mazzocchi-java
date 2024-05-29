package org.example.chain;

public abstract class Militare {
    private Militare superiore;
    private double stipendio;

    public Militare getSuperiore() {
        return superiore;
    }

    public void setSuperiore(Militare superiore) {
        this.superiore = superiore;
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public void doCheck(double cifra){
        if(cifra <= this.stipendio) System.out.println("Lo stipendio di " + this.getClass().getSimpleName() + " è maggiore di " + cifra);
        if(superiore != null) {
            this.superiore.doCheck(cifra);
        } else {
            System.out.println("Non ci sono altri ufficiali di grado superiore");
        }
    }
}
