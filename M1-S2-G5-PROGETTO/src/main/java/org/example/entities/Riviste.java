package org.example.entities;

public class Riviste extends Biblioteca{

    private Period period;
        public Riviste(long isbn, String title, int anno, int pages,Period period) {
        super(isbn, title, anno, pages);
        this.period = period;
    }

    public Period getPeriod() {
        return period;
    }

    @Override
    public String toString() {
            return "\nRivista: " + getTitle()+ "\nISBN: " + getIsbn() + "\nYear: " + getAnno()+
                    "\nPages: " + getPages()+"\nPeriod: " + period;
        }


}
