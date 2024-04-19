import java.util.Scanner;

public class Main {


    public static RegistrazioneAudio setRegistrazioneAudio(Scanner scanner) {
        System.out.println("Inserisci il titolo:");
        String title = scanner.nextLine();
        System.out.println("Inserisci la durata (in minuti):");
        int time = scanner.nextInt();
        System.out.println("Inserisci il volume:");
        int volume = scanner.nextInt();
        System.out.println("Inserisci se è in play (true/false):");
        boolean play = scanner.nextBoolean();
        return new RegistrazioneAudio(title, time, volume, play);
    }
    public static Video setAudio(Scanner scanner) {
        System.out.println("Inserisci il titolo:");
        String title = scanner.nextLine();
        System.out.println("Inserisci la durata (in minuti):");
        int time = scanner.nextInt();
        System.out.println("Inserisci il volume:");
        int volume = scanner.nextInt();
        System.out.println("Inserisci se è in play (true/false):");
        boolean play = scanner.nextBoolean();
        System.out.println("Inserisci la luminosità:");
        int lum = scanner.nextInt();
        return new Video(title, time, volume, play,lum);
    }
    public static Immagine setImmagine(Scanner scanner) {
        System.out.println("Inserisci il titolo:");
        String title = scanner.nextLine();
        System.out.println("Inserisci la durata (in minuti):");
        int time = scanner.nextInt();
        System.out.println("Inserisci se è in play (true/false):");
        boolean play = scanner.nextBoolean();
        System.out.println("Inserisci la luminosità:");
        int lum = scanner.nextInt();
        return new Immagine(title, time,play,lum);
    }

    public static void main(String[] args) {

        Riproduzione[] r1 = new Riproduzione[5];
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        int n;

        do {
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Crea una nuova riproduzione.");
            System.out.println("2. Crea una nuova immagine.");
            System.out.println("3. Crea un nuovo video.");
            System.out.println("4. Mostra array");
            System.out.println("5. Avvia elementi");
            System.out.println("0. Esci");

            n = scanner.nextInt();
            scanner.nextLine();

            switch (n) {
                case 1:
                    if (index < r1.length) {
                        r1[index++] = setRegistrazioneAudio(scanner);
                    } else {
                        System.out.println("Array pieno, impossibile aggiungere un'altra riproduzione.");
                    }
                    break;
                case 2:
                    if (index < r1.length) {
                        r1[index++] = setAudio(scanner);
                    } else {
                        System.out.println("Array pieno, impossibile aggiungere un altro audio.");
                    }
                    break;
                case 3:
                    if (index < r1.length) {
                        r1[index++] = setImmagine(scanner);
                    } else {
                        System.out.println("Array pieno, impossibile aggiungere un'altra immagine.");
                    }
                    break;
                case 4:
                    for (int i = 0; i < index; i++) {
                            System.out.println( r1[i].getInfo());
                    }
                    break;
                case 5:
                    System.out.println("Scegli quale oggetto vedere (da 1 a 5):");
                    int i = scanner.nextInt() - 1;
                    if (i >= 0 && i < r1.length) {
                        if (r1[i] instanceof RegistrazioneAudio) {
                            System.out.println(((RegistrazioneAudio) r1[i]).play());
                        } else if(r1[i] instanceof Video) {
                            System.out.println(((Video) r1[i]).play());
                        }else{
                            System.out.println(((Immagine) r1[i]).show());
                        }
                    } else {
                        System.out.println("Indice non valido. Inserisci un numero tra 1 e 5.");
                    }
                    break;
                case 0:
                    System.out.println("Uscita dal programma.");
                    break;
                default:
                    System.out.println("Opzione non valida.");
                    break;
            }
        } while (n != 0);

        scanner.close();

    }
}