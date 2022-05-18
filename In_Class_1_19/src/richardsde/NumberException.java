package richardsde;

import java.util.Scanner;

public class NumberException {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean validInput = false;
        int numerator = 10;
        while (!validInput){
            try{
                System.out.println("Please enter a non-zero number.");
                int i = Integer.parseInt(in.nextLine());
                checkRange(i);
                numerator = numerator/i;
                validInput = true;
                System.out.println(numerator);
            } catch (NegativeNumberException e){
                System.out.println(e.getMessage());
            } catch (ArithmeticException e){
                System.out.println("You did not enter a non-zero number.");
            } catch (NumberFormatException e){
                System.out.println("You probably entered a non-integer number");
            }
        }
    }

    private static void checkRange(int i) throws NegativeNumberException{
        if (i < 0){
            throw new NegativeNumberException("The number " + i + " is our of range");
        }
    }
}
