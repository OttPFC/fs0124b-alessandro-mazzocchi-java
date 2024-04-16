package ex_while;
import java.util.Scanner;
public class esercizio_while {

    public static String strSep(){

        System.out.println("Inserisci una parola: ");
        Scanner tastiera = new Scanner(System.in);
        String str = tastiera.nextLine();

        String[] splitted = str.split("");

        StringBuilder sb = new StringBuilder();
        for (String s : splitted) {
            sb.append(s).append(",");
        }


        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }






    public static void main (String[] args){

        String result = strSep();
        System.out.println(result);
    }
}
