import java.util.Scanner;

public class Macchina {
    public static float es2() {
        System.out.println("Inserisci i km percorsi: ");
        Scanner scanner = new Scanner(System.in);
        float km = scanner.nextInt();
        System.out.println("Inserisco i litri consumati: ");
        float litri = scanner.nextInt();
        float res = 0;
        try {
            if (km != 0 && litri != 0) {
                res = km / litri;
                System.out.println("Sono stati percorsi " + res + "km per litro");
            } else {
                System.out.println("Non puoi inserire dei valori a zero.");
            }

        } catch (Exception e) {
            System.out.println("Qualcosa è andato storto");
        }

        return res;
    }
}
