import java.util.Scanner;

public class Main {

    public static int moltiplica() {
        int firstNumber, secondNumber;
        Scanner tastiera = new Scanner(System.in);



        System.out.println("Inserisci il primo numero:");
        firstNumber = tastiera.nextInt();


        System.out.println("Inserisci il secondo numero:");
        secondNumber = tastiera.nextInt();

        int risultato = firstNumber * secondNumber;
        return risultato;
    }

    public static String concat(){
       final int risultato = moltiplica();
        return "Il risultato della moltiplicazione è: " + risultato;
    }

    /*
    public static String inseriscInArray(){


    }
*/

    public static String concatString(){
        Scanner tastiera = new Scanner (System.in);
        System.out.println("Scrivi una parola:");
        String first = tastiera.nextLine();
        System.out.println("Scrivi una parola:");
        String second = tastiera.nextLine();
        System.out.println("Scrivi una parola:");
        String third = tastiera.nextLine();
        String conc = first.concat(" ").concat(second).concat(" ").concat(third);
        StringBuilder revRes = new StringBuilder(conc);
        revRes.reverse();
        String result = "Queste sono le parole che hai scritto: " + conc + "\nQuesta è in reverse: " + revRes.toString();
        return result ;
    }

    public static String rettangolo(){
        Scanner tastiera = new Scanner (System.in);
        System.out.println("Calcola il perimetro del rettangolo.");
        System.out.println("Inserisci la base:");
        float base = tastiera.nextFloat();
        System.out.println("Inserisci l'altezza:");
        float altezza= tastiera.nextFloat();
        float result = (base + altezza) * 2;
        return "L'area è: " + result;
    }

    public static String pariDispari(){
        Scanner tastiera = new Scanner (System.in);
        System.out.println("Inserisci un numero, se è pari restituirò 0 altrimenti 1: ");
        int number = tastiera.nextInt();
        if(number % 2 == 0){
            return "Il numero è pari : 0";
        }else{
            return "Il numero è dispari : 1";
        }
    }

    public static String areaTriangolo(){

        Scanner tastiera = new Scanner (System.in);
        System.out.println("Calcoliamo l'area del trinagolo.");
        System.out.print("Inserisci il primo lato: ");
        float first = tastiera.nextFloat();
        System.out.print("Inserisci il secondo lato: ");
        float second = tastiera.nextFloat();
        System.out.print("Inserisci il terzo lato: ");
        float third = tastiera.nextFloat();

        double s = (first + second + third) / 2.0;
        double area = Math.sqrt(s * (s - first) * (s - second) * (s - third));
        return "L'area è:" + area;
    }

    public static void main(String[] args) {
        String result = concat();
        System.out.println(result);
        //String result = concatString();
        //System.out.println(result);
        //String tri = rettangolo();
        //System.out.println(tri);
        //String numb = pariDispari();
        //System.out.println(numb);
        String area = areaTriangolo();
        System.out.println(area);
    }
}
