/*
 *
 *
 *
 */
package richardsde.fileIO;

import javafx.stage.FileChooser;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileIO {
    public static void main(String[] args) {

        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("test.txt"));
            dos.writeInt(8);
            dos.writeDouble(3.14);
            dos.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e){
            e.printStackTrace();
        }
        read(Paths.get("test.txt"));

    }

    private static void read(Path textFilePath){
        try (DataInputStream dis =
                     new DataInputStream(new FileInputStream(textFilePath.toFile()))) {
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            e.printStackTrace();
        }
    }




}
