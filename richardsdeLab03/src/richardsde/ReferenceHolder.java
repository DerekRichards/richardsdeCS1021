/*
 * Course: CS1021-081
 * Winter 2020-2021
 * Lab 3
 * Name: Derek Richards
 * Created: 12/16/2020
 */
package richardsde;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents a collection of references.
 */
public class ReferenceHolder {
    private final List<Reference> references;

    /**
     * Constructor of the class. Initializes the references list.
     */
    public ReferenceHolder(){
        references = new ArrayList<>();
    }

    /**
     * Adds a book to the list of references.
     * @param book - A book used as a reference.
     */
    public void addReference(Book book){
        references.add(book);
    }

    /**
     * Adds an article to the list of references.
     * @param article - An article used as a reference.
     */
    public void addReference(Article article){
        references.add(article);
    }

    @Override
    public String toString(){
        String temp = "";
        if (!references.isEmpty()){
            for (Reference reference : references){
                temp += reference;
            }
        }
        return temp;
    }

    /**
     * Removes a reference from the list.
     *
     * @param uniqueID - The identifier of the reference to be removed.
     * @return - True if the reference is removed from the list, false otherwise.
     */
    public boolean removeReference(String uniqueID){
        if (!references.isEmpty()){
            for (Reference reference : references){
                if (reference.getMyUniqueID().equals(uniqueID)){
                    references.remove(reference);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Updates a reference that has been added to the list.
     *
     * @param uniqueID - The identifier of the object to be updated.
     * @param out - Prompts the user for output.
     * @param in - Reads the user's input.
     * @return - True if the reference is updated, false otherwise.
     */
    public boolean updateReference(String uniqueID, PrintStream out, Scanner in){
        for (Reference reference : references){
            if (reference.getMyUniqueID().equals(uniqueID)){
                reference.promptForUpdate(out, in);
                return true;
            }
        }
        return false;
    }

}
