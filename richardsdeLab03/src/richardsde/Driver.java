/*
 * Course: CS1021-081
 * Winter 2020-2021
 * Lab 3
 * Name: Derek Richards
 * Created: 12/16/2020
 */
package richardsde;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * The Driver class for the program.
 */
public class Driver {
    public static void main(String[] args){
        ReferenceHolder holder = new ReferenceHolder();
        PrintStream out = new PrintStream(System.out);
        Scanner in = new Scanner(System.in);
        int input = -1;


        while (input != 0){
            out.println("Enter 0 to exit the program.");
            out.println("Enter 1 to enter a new book into the reference set.");
            out.println("Enter 2 to enter a new article into the reference set.");
            out.println("Enter 3 to update a reference.");
            out.println("Enter 4 to printout the entries in Bibtex format.");
            out.println("Enter 5 to remove a reference.");
            input = in.nextInt();
            in.nextLine();
            // Magic number without this
            final int five = 5;
            switch (input) {
                case 0:
                    out.println("Thanks for using the program.");
                    break;
                case 1:
                    addBook(out, in, holder);
                    break;
                case 2:
                    addArticle(out, in, holder);
                    break;
                case 3:
                    updateReference(out, in, holder);
                    break;
                case 4:
                    printOut(out, holder);
                    break;
                case five:
                    removeReference(out, in, holder);
                    break;
                default:
                    out.println("Invalid Entry.");
            }
        }



    }

    private static void addBook(PrintStream out, Scanner in, ReferenceHolder holder){
        Book book = new Book();
        book.promptToInitialize(out, in);
        holder.addReference(book);
    }

    private static void addArticle(PrintStream out, Scanner in, ReferenceHolder holder){
        Article article = new Article();
        article.promptToInitialize(out, in);
        holder.addReference(article);
    }

    private static void updateReference(PrintStream out, Scanner in, ReferenceHolder holder){
        out.println("Enter the ID of the reference that you want to update.");
        String uniqueID = in.next();
        in.nextLine();
        holder.updateReference(uniqueID, out, in);
    }

    private static void printOut(PrintStream out, ReferenceHolder holder){
        out.println(holder);
    }

    private static void removeReference(PrintStream out, Scanner in, ReferenceHolder holder){
        out.println("Enter the ID of the reference that you want to remove.");
        String uniqueID = in.next();
        in.nextLine();
        holder.removeReference(uniqueID);
    }
}
