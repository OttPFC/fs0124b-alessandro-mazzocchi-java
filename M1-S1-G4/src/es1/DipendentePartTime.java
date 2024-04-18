package es1;

public class DipendentePartTime extends Dipendente {
    public DipendentePartTime(int matricola, String[] dipartimento) {
        super(matricola,  dipartimento);
    }

    @Override
    public float getStipendio(float ore, float euroH){
    float salario = ore * euroH;
        return  salario  ;
    }
}
