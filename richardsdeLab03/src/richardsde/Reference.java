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
 * Represents bibliographical information about a reference.
 */
public abstract class Reference {
    private static int instanceCount = 0;
    protected String author;
    protected final String myUniqueID;
    protected int publicationYear;
    protected String title;

    /**
     * Creates a new reference and creates an ID for that reference.
     */
    public Reference(){
        myUniqueID = "REF" + instanceCount;
        instanceCount++;
    }

    /**
     * Prompts the user for the reference's initial attributes.
     *
     * @param out - Prompts the user for output.
     * @param in - Reads in what the user typed.
     */
    public abstract void promptToInitialize(PrintStream out, Scanner in);

    /**
     * Prompts the user for an update on an existing reference.
     *
     * @param out - Prompts the user for output.
     * @param in - Reads in what the user typed.
     */
    public void promptForUpdate(PrintStream out, Scanner in){
        out.println("Enter the updated author of the reference.");
        author = in.nextLine();
        out.println("Enter the updated title of the reference.");
        title = in.nextLine();
        out.println("Enter the updated copyright year of the reference.");
        publicationYear = in.nextInt();
        in.nextLine();
    }

    public String getAuthor(){
        return author;
    }

    public String getMyUniqueID(){
        return myUniqueID;
    }

    public int getPublicationYear(){
        return publicationYear;
    }

    public String getTitle(){
        return title;
    }

}
