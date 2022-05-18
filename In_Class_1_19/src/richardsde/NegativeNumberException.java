
package richardsde;

/**
 * This is an exception for when a number is less than zero.
 */
public class NegativeNumberException extends IllegalArgumentException {

    public NegativeNumberException(){
        super();
    }

    public NegativeNumberException(String message){
        super(message);
    }


}
