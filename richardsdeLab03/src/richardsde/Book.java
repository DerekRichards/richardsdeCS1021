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
 * Represents bibliographical information about a book.
 */
public class Book extends Reference {
    private String publisher;


    @Override
    public void promptToInitialize(PrintStream out, Scanner in){
        out.println("Enter the author of the reference.");
        author = in.nextLine();
        out.println("Enter the title of the reference.");
        title = in.nextLine();
        out.println("Enter the copyright year of the reference.");
        publicationYear = in.nextInt();
        in.nextLine();
        out.println("Enter the publisher of the book.");
        publisher = in.nextLine();
    }

    /**
     * Prompts the user for an update on an existing book.
     *
     * @param out - Prompts the user for output.
     * @param in - Reads in what the user typed.
     */
    public void promptForUpdate(PrintStream out, Scanner in){
        super.promptForUpdate(out, in);
        out.println("Enter the updated publisher for the book.");
        publisher = in.nextLine();
    }

    public String getPublisher(){
        return publisher;
    }

    @Override
    public String toString(){
        return "@BOOK { " + getMyUniqueID() + ",\n"
                + "author = \"" + getAuthor() + "\",\n"
                + "title = \"" + getTitle() + "\",\n"
                + "publisher = \"" + getPublisher() + "\",\n"
                + "year = \"" + getPublicationYear() + "\"\n"
                + "}\n";
    }
}
