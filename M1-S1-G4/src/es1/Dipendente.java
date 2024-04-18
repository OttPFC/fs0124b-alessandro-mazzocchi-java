package es1;

abstract class Dipendente {

    private int matricola;
    private float stipendio;
    private String[] dipartimento = {"PRODUZIONE", "AMMINISTRAZIONE", "VENDITE"};

    public Dipendente(int matricola, float stipendio, String[] dipartimento) {
        this.matricola = matricola;
        this.stipendio = stipendio;
        this.dipartimento = dipartimento;
    }

    public Dipendente(int matricola, String[] dipartimento) {
        this.matricola = matricola;
        this.dipartimento = dipartimento;
    }

    public String getMatricola() {
        return "IL numero di matricola è: " + matricola;
    }

    public float getStipendio() {
        return stipendio;
    }

    public String getDipartimento() {
        String dip = dipartimento[0] ;
        return dip;
    }
    public String setDipartimento(String dip) {

        return dip = dipartimento[0] ;
    }


    public abstract float getStipendio(float ore, float euroH);
}
