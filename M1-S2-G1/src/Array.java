import java.util.Scanner;

public class Array {
    public static int[] es1(){
        Scanner scanner = new Scanner(System.in);
        int array[] =new int[5];
        int n;
        try {
            for (int i = 0; i < array.length; i++) {
                int num = (int) (Math.random() * 11 + 1);
                array[i] = num;
                System.out.println(array[i]);
            }
            do {
                System.out.println("Vuoi sostituire un numero ?");
                System.out.println("Inserisci il numero, per uscire inserisci 0: ");
                n = scanner.nextInt();
                System.out.println("In che posizione vuoi inserirlo ? (tra 1 e 5)");
                int m = scanner.nextInt();
                array[m -1] = n;
                for (int i = 0; i < array.length; i++) {
                    System.out.println(array[i]);
                }
            }while (n != 0);

        }catch(Exception e) {
            System.out.println("Something went wrong");
        }
        return array;
    }
}
