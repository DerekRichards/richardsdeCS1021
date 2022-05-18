package richardsde;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadingFile {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        try(Scanner scan = new Scanner(new File("declaration.txt"))) {
            while (scan.hasNext()){
                words.add(scan.next());
            }

        } catch (FileNotFoundException e){
            System.out.println("The file could not be found.");
        }

//        words.stream()
//                .filter(word -> Character.toLowerCase(word.charAt(0)) == 'a').distinct()
//                .forEach(System.out::println);
        System.out.println(words.stream().count());

    }

}
