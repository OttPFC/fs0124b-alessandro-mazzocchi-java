package org.example;

import org.example.entities.Libri;
import org.example.entities.Riviste;
import org.example.entities.Period;
import org.example.service.FileBiblioService;
import java.util.Scanner;

public class Main {

    private static void aggiungiLibro(Scanner scanner, FileBiblioService biblio) {
        System.out.println("Inserisci il titolo: ");
        String title = scanner.nextLine();
        System.out.println("Inserisci l'isbn: ");
        long isbn = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Inserisci l'autore: ");
        String author = scanner.nextLine();
        System.out.println("Inserisci il genere: ");
        String gen = scanner.nextLine();
        System.out.println("Inserisci l'anno di pubblicazione: ");
        int anno = scanner.nextInt();
        System.out.println("Inserisci il numero di pagine: ");
        int pages = scanner.nextInt();
        Libri book = new Libri(isbn, title, anno, pages, author, gen);
        biblio.addBooks(book);
        System.out.println("Libro aggiunto con successo!");
    }


    private static void aggiungiRiviste(Scanner scanner, FileBiblioService biblio) {
        System.out.println("Inserisci il titolo: ");
        String title = scanner.nextLine();
        System.out.println("Inserisci l'isbn: ");
        long isbn = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Inserisci l'anno di pubblicazione: ");
        int anno = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserisci il numero di pagine: ");
        int pages = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Con quale periodicità ricevere la rivista ?");
        System.out.println("1 - Settimanale");
        System.out.println("2 - Mensile");
        System.out.println("3 - Semestrale");
        System.out.print("Inserisci opzione: ");
        int p = Integer.parseInt(scanner.nextLine());
        Period period = switch (p) {
            case 1 -> Period.SETTIMANALE;
            case 2 -> Period.MENSILE;
            case 3 -> Period.SEMESTRALE;
            default -> throw new IllegalArgumentException("Opzione non valida.");
        };
        biblio.addBooks(new Riviste(isbn,title,anno,pages,period));
        System.out.println("Rivista aggiunta con successo!");
    }





    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        FileBiblioService biblio = new FileBiblioService();

        System.out.println("Benvenuto nel programma di gestione biblioteca!");
        int i;
        String input;

        do {
            System.out.println("1 - Inserisci un libro.");
            System.out.println("2 - Inserisci una rivista.");
            System.out.println("3 - Cerca per isbn.");
            System.out.println("4 - Cerca per Autore.");
            System.out.println("5 - Cerca per Anno.");
            System.out.println("6 - Elimina per isbn.");
            System.out.println("7 - Visualizza tutti.");
            System.out.print("\nInserisci opzione: ");
            i = Integer.parseInt(tastiera.nextLine());
            switch (i) {
                case 1:
                    aggiungiLibro(tastiera, biblio);
                    break;
                case 2:
                    aggiungiRiviste(tastiera, biblio);
                    break;
                case 3:
                    System.out.println("Inserisci l'isbn: ");
                    long isbn = tastiera.nextLong();
                    biblio.findByIsbn(isbn).forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Inserisci l'autore: ");
                    String author = tastiera.nextLine();
                    biblio.findByAuthor(author).forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Inserisci l'anno: ");
                    int anno = tastiera.nextInt();
                    biblio.findByYear(anno).forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Inserisci l'isbn: ");
                    int isbni = tastiera.nextInt();
                    biblio.removeByIsbn(isbni);
                    break;
                case 7:
                    biblio.getAllBooks().forEach(System.out::println);
                    break;
                    default:
                        System.out.println("Opzione non valida.");
                        break;
            }
            System.out.println("Vuoi continuare? (sì/no)");
            input = tastiera.nextLine().toLowerCase();
        }while (!input.equals("no"));
        tastiera.close();
    }
}
