package es2;

public class Sim {
    private int tNumber;
    private float credito;
    private int[] lastCall = new int[5] ;


    public Sim(int tNumber, float credito) {
        tNumber = tNumber;
        credito = credito;
        lastCall = new int[0];
    }

}
