package Lab7;

import edu.msoe.winplotterfx.WinPlotterFX;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Lab7 {
    WinPlotterFX plotter = new WinPlotterFX();

    public void writeToFile(String filename, String title, int width, int
            height, String bgColor, List<Shape> shapes) throws IOException {
        PrintWriter fileWriter = new PrintWriter(new File(filename));
        fileWriter.println(title);
        fileWriter.print(width);
        fileWriter.print(height);
        fileWriter.println();
        fileWriter.println(bgColor);
        if (shapes.isEmpty()){
            throw new IOException("Can not write data for empty shapes");
        } else if (shapes.size() != 6){
            throw new IOException("Data for six shapes needs to be written into the file.");
        } else {
            for (Shape shape : shapes){
                fileWriter.println(shape.toString());
            }
        }

    }
}
