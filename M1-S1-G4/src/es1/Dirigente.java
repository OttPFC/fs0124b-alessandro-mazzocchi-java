package es1;

import es1.Dipendente;

public class Dirigente extends Dipendente {
    public Dirigente(int matricola, float stipendio, String[] dipartimento) {
        super(matricola, stipendio, dipartimento);
    }



    @Override
    public float getStipendio(float bonus) {
        float salary = super.getStipendio();
        return salary + bonus;
    }
}
