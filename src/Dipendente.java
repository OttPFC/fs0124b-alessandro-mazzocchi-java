public class Dipendente {

    private int matricola;
    private float stipendio;
    private String[] dipartimento = new String["PRODUZIONE","AMMINISTRAZIONE","VENDITE"];

    public Dipendente(int matricola, float stipendio) {
        this.matricola = matricola;
        this.stipendio = stipendio;
    }

    public int getMatricola() {
        return matricola;
    }
    public float getStipendio() {
        return stipendio;
    }
}
