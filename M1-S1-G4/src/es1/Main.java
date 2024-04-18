package es1;

import es1.*;


import es1.DipendenteFullTime;

public class Main {
    public static void main(String[] args) {
/*
        Dipendente alberto = new Dipendente(1, 2000.45F, new String[]{"PRODUZIONE"});
        Dipendente carlo = new Dipendente(2, 2500.45F, new String[]{"AMMINISTRAZIONE"});
        Dipendente ulderico = new Dipendente(3, 1000.45F, new String[]{"VENDITE"});
        System.out.println(alberto.getStipendio());
        System.out.println(alberto.getMatricola());
        //System.out.println(carlo.setDipartimento(););
        System.out.println(alberto.getDipartimento());

        Dipendente[] dip = new Dipendente[]{alberto, carlo, ulderico};

        for (int i = 0; i < dip.length; i++) {
            System.out.println(dip[i].getMatricola());


        }
        */
        DipendenteFullTime a = new DipendenteFullTime(4,4500.6F,new String[] {"AMMINISTRAZIONE"});
        System.out.println(a.calculateSalary());
        DipendentePartTime b = new DipendentePartTime(4,new String[] {"PRODUZIONE"});
        System.out.println(b.getStipendio(8,15));
        Dirigente c = new Dirigente (5,6500.9F,new String[] {"DIREZIONE"});
        System.out.println(c.getStipendio(1200F));

        Dipendente[] dipe = new Dipendente[]{a,b,c};
        for(int i=0;i<dipe.length;i++){
            float salary = dipe[i].getStipendio();

        }

    }
}
