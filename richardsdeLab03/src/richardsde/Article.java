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
 * Represents bibliographical information about an article published in a journal.
 */
public class Article extends Reference {
    private int endingPage;
    private int startingPage;
    private String journal;



    @Override
    public void promptToInitialize(PrintStream out, Scanner in){
        out.println("Enter the author of the reference");
        author = in.nextLine();
        out.println("Enter the title of the reference.");
        title = in.nextLine();
        out.println("Enter the copyright year of the reference.");
        publicationYear = in.nextInt();
        in.nextLine();
        out.println("Enter the title of the journal.");
        journal = in.nextLine();
        out.println("Enter the first page number of the article.");
        startingPage = in.nextInt();
        out.println("Enter the last page number of the article.");
        endingPage = in.nextInt();
        in.nextLine();
    }

    /**
     * Prompts the user for an update on an existing article.
     *
     * @param out - Prompts the user for output.
     * @param in - Reads in what the user typed.
     */
    public void promptForUpdate(PrintStream out, Scanner in){
        super.promptForUpdate(out, in);
        out.println("Enter the updated title of the journal.");
        journal = in.nextLine();
        out.println("Enter the updated first page number of the article.");
        setStartingPage(in.nextInt());
        out.println("Enter the updated last page number of the article.");
        setEndingPage(in.nextInt());
        in.nextLine();
    }

    public int getEndingPage(){
        return endingPage;
    }

    public int getStartingPage(){
        return startingPage;
    }

    public String getJournal(){
        return journal;
    }

    @Override
    public String toString(){
        return "@ARTICLE { " + getMyUniqueID() + ",\n"
                + "author = \"" + getAuthor() + "\",\n"
                + "title = \"" + getTitle() + "\",\n"
                + "journal = \"" + getJournal() + "\", \n"
                + "pages = \"" + getStartingPage() + "-" + getEndingPage() + "\",\n"
                + "year = \"" + getPublicationYear() + "\"\n"
                + "}\n";
    }

    private boolean setEndingPage(int endingPage){
        if (endingPage < this.startingPage){
            return false;
        } else {
            this.endingPage = endingPage;
            return true;
        }
    }

    private boolean setStartingPage(int startingPage){
        if (startingPage > this.startingPage || startingPage <= 0){
            return false;
        } else {
            this.startingPage = startingPage;
            return true;
        }
    }
}
