/*
* Course: CS1021-081
* Winter 2020-2021
* Lab 1
* Name: Derek Richards
* Created: 12/2/2020
 */
package richardsde;
import us.msoe.csse.taylor.audio.WavFile;

import java.util.Scanner;
import java.util.ArrayList;
/**
 * This is a class that uses a WavFile java class to create .wav files.
 */
public class WavGenerator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input;
        System.out.println("Welcome to the WavGenerator program.");

        do {
            System.out.print("Enter 1 to generate a .wav file with audio samples" +
                    " in reversed order, 2 to generate a tone at a specific frequency, " +
                    "or 0 to exit the program: ");
            input = in.nextInt();
            if (input == 1){
                reverseSamples();
            } else if (input == 2){
                singleChannel();
            } else if (input == 0){
                System.out.println("Thanks for using the program!");
            } else {
                System.out.println("That input is invalid.");
            }
        } while (input != 0);
    }


    /**
     * Reads in a .wav file and creates a new file with the samples reversed.
     */
    private static void reverseSamples(){
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a file name (without the .wav extension): ");
        String fileName = in.next();


        // Creates a regular wavFile object
        WavFile wavFile = new WavFile(fileName + ".wav");
        System.out.println(wavFile);
        // Store the samples in the object in an ArrayList
        ArrayList<Double> samples = wavFile.getSamples();
        ArrayList<Double> reversedSamples = new ArrayList<>();

        // Reversing the samples in the ArrayList.
        if (!(samples == null)){
            for(int x = samples.size() - 1; x >= 0; x--){
                reversedSamples.add(samples.get(x));
            }
        }

        // Sets the samples in a new WavFile object to be in reverse
        WavFile reversedWavFile = new WavFile(fileName + "Rev.wav",
                wavFile.getNumChannels(), wavFile.getNumFrames(),
                wavFile.getValidBits(), wavFile.getSampleRate());
        reversedWavFile.setSamples(reversedSamples);

        System.out.println(reversedWavFile);
        System.out.println(reversedWavFile.close());
    }

    /**
     * Creates a .wav file with one second of sound at a specific frequency.
     */
    private static void singleChannel(){
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a file name (without the .wav extension) and a frequency: ");
        String fileName = in.next() + ".wav";
        double freq = in.nextDouble();

        final long numFrames = 8000; // Values for the multi-parameter constructor
        final int validBits = 8;
        final long sampleRate = 8000;
        WavFile wavFile = new WavFile(fileName, 1, numFrames, validBits, sampleRate);
        ArrayList<Double> samples = new ArrayList<>();

        for (int i = 0; i < wavFile.getSampleRate(); i++){
            samples.add(Math.sin((2 * Math.PI) * i * (freq/ wavFile.getSampleRate())));
        }

        wavFile.setSamples(samples);
        System.out.println(wavFile);
        System.out.println(wavFile.close());

    }

}
