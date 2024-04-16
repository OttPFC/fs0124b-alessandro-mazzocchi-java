import java.util.Scanner;

public class Main {

    public static boolean stringaPariDispari(){
        System.out.println("Scrivi una parola per sapere se la lunghezza è pari o dispari");
        Scanner tastiera = new Scanner(System.in);
        String str = tastiera.nextLine();
        return str.length() % 2 == 0;

    }


    public static boolean annoBisestile(){

        System.out.print("Inserisci un anno per sapere se è bisestile: ");
        Scanner tastiera = new Scanner(System.in);
        int anno = tastiera.nextInt();
        if(anno > 1584 && (anno % 4 == 0 || anno % 100 == 0 && anno % 400 == 0)){
            return true;
        }else{
            return false;
        }
    }




    public static void main(String[] args) {
        boolean result = stringaPariDispari();
        System.out.println(result ? "La lunghezza della stringa è pari" : "La lunghezza della stringa è dispari");
        boolean res = annoBisestile();
        System.out.println(res ? "L'anno è bisestile" : "L'anno non è bisestile");
        }
    }
