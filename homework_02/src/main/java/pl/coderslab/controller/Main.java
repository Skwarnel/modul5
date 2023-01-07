package pl.coderslab.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File file = new File("target/workers.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] tokens = line.split(" ");
                for (String token : tokens) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Brak pliku. " + e.getLocalizedMessage());
        }
    }
}
