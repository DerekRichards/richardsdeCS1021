package richardsde;


import java.util.Scanner;

public class Driver {
    public static void main(String[] args){
        System.out.println("What is your name? Enter full name separated by spaces:");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        Employee employee = new Employee(name, 1);
        //System.out.println("Employee name: " + employee.getName());
        employee.display();
    }
}
