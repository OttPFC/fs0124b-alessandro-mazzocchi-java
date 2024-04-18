package es1;

import es1.Dipendente;

public class DipendenteFullTime extends Dipendente {
    public DipendenteFullTime(int matricola, float stipendio, String[] dipartimento) {
        super(matricola, stipendio, dipartimento);
    }

    public float calculateSalary(){

        return super.getStipendio();
    }

    @Override
    public float getStipendio(){
        return super.getStipendio();
    }
}
