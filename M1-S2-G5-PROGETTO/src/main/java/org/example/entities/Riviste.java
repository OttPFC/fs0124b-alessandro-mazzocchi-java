package org.example.entities;

import java.io.Serializable;

public class Riviste extends Biblioteca implements Serializable {

    private Period period;
        public Riviste(long isbn, String title, int anno, int pages,Period period) {
        super(isbn, title, anno, pages);
        this.period = period;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
            this.period = period;

    }
    @Override
    public String Info() {
            return "Rivista: " + getTitle()+ "ISBN: " + getIsbn() + "\nYear: " + getAnno()+
                    "\nPages: " + getPages()+"\nPeriod: " + period;
        }


}
