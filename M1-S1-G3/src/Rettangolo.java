public class Rettangolo {

    private float altezza;
    private float larghezza;
    public Rettangolo(float altezza, float larghezza){
        this.altezza = altezza;
        this.larghezza = larghezza;
    }


        public float getPerimetro(){
            float perimetro = (altezza + larghezza) * 2;
            return perimetro;
        }
        public float getArea(){
            float perimetro = altezza * larghezza;
            return perimetro;
        }
        public void stampaRettangolo(Rettangolo r){
            System.out.println("Perimetro: " + r.getPerimetro() + "\n" + "Area:" + r.getArea());
        }
        public void stampaDueRettangoli(Rettangolo r, Rettangolo r2){
            System.out.println("Somma area:" + (r.getArea() + r2.getArea())) ;
            System.out.println("Somma perimetri: " + (r.getPerimetro() + r2.getPerimetro()));
        }
    }

