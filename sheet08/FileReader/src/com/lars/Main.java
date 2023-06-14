package com.lars;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void ParseFileScaner() throws FileNotFoundException {
        var scanner = new Scanner(new FileInputStream("bigInput.txt"));

        long sum = 0;
        while (scanner.hasNext()) {
            sum += scanner.nextInt();
        }
        System.out.println("Sum is: " + sum);
    }

    public static void ParseFileBufferedReader() throws IOException {
        var reader = new BufferedReader(new FileReader("bigInput.txt"));

        String line;
        long sum = 0;
        while((line = reader.readLine()) != null) {
            sum += Integer.parseInt(line);
        }

        System.out.println("Sum is: " + sum);
    }

    public static void main(String[] args) {
	   try {
           long start = System.currentTimeMillis();
           ParseFileScaner();
           long end = System.currentTimeMillis();

           System.out.println("Took: " + (end - start) + "ms");
       } catch (FileNotFoundException ex) {
           System.out.println("File not found: " + ex.getMessage());
       }


        try {
            long start = System.currentTimeMillis();
            ParseFileBufferedReader();
            long end = System.currentTimeMillis();

            System.out.println("Took: " + (end - start) + "ms");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
