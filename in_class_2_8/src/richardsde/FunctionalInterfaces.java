package richardsde;

import java.util.ArrayList;
import java.util.List;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        int firstInt = 5;
        int secondInt = 8;

        BinaryIntOperation add = (a, b) -> a + b;
        BinaryIntOperation subtract = (c, d) -> c - d;
        UnaryIntOperation negate = a -> -a;
        UnaryIntOperation increment = b -> b + 1;

        int sum = add.apply(firstInt, secondInt);
        int sub = subtract.apply(firstInt, secondInt);

        ArrayList<Integer> input = new ArrayList<Integer>();
        for (int i = 0; i <= 6; i++){
            input.add(i);
        }
        ArrayList<Integer> result1 = applyToEach(input, a -> -a);

        result1.forEach(System.out::print);
        System.out.println();

        ArrayList<Integer> result2 = applyBinary(input, (a, b) -> a + b);

        result2.forEach(System.out::print);

    }

    public static ArrayList<Integer> applyToEach(ArrayList<Integer> input, UnaryIntOperation op){
        ArrayList<Integer> transformed = new ArrayList<>();
        for (int i = 0; i < input.size(); i++){
            int element = input.get(i);
            int result = op.apply(element);
            transformed.add(result);
        }
        return transformed;
    }

    public static ArrayList<Integer> applyBinary(ArrayList<Integer> input, BinaryIntOperation op){
        ArrayList<Integer> transformed = new ArrayList<>();
        for (int i = 0; i < input.size(); i++){
            int element = input.get(i);
            int result = op.apply(element, i);
            transformed.add(result);
        }
        return transformed;
    }


}
