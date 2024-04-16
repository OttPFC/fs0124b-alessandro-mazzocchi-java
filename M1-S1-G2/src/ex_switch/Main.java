

package ex_switch;
import java.util.Scanner;
public class Main {

    public static String numberToString(){
        System.out.println("Inserisci un numero da 0 a 3 per vederlo in lettere: ");
        Scanner tastiera = new Scanner(System.in);
        int number = tastiera.nextInt();
        //String[] nToS = {"","uno","due","tre"};
        switch(number){
            case 0:
                return "zero";
            case 1:
                return "uno";
            case 2:
                return "due";
            case 3:
                return "tre";
            default:
                return "Numero non valido";
        }

    }

    public static void main(String[] args) {
        String result = numberToString();
        System.out.println(result);
    }
}
