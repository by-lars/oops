package com.lars;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	   //Slow method
        try {
           long start = System.currentTimeMillis();
           ParseFileScaner();
           long end = System.currentTimeMillis();

           System.out.println("Took: " + (end - start) + "ms");
       } catch (FileNotFoundException ex) {
           System.out.println("File not found: " + ex.getMessage());
       }

        //Fast method
        try {
            long start = System.currentTimeMillis();
            ParseFileBufferedReader();
            long end = System.currentTimeMillis();

            System.out.println("Took: " + (end - start) + "ms");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        //Pattern matching
        try {

            String log = Files.readString(Paths.get("build.log"));

            Pattern p = Pattern.compile("Warning\\s(?<number>\\d+)\\sof\\s(?<total>\\d+):\\n\\n\\s*in\\smodule\\s(?<module>[\\w+.]*)\\n\\s\\sat (?<file>[/\\w+-.]*)\\sline\\s(?<line>\\d+)");
            Matcher matcher = p.matcher(log);

            int count=0;
            while(matcher.find()) {
                String number = matcher.group("number");
                String line = matcher.group("line");
                String file = matcher.group("file");

                System.out.println("Warning " + number + " at line " + line + " in file " + file);
                count++;
            }

            System.out.println("Found " + count + " warnings");

        } catch (Exception ex) {
            System.err.println("what u doin: " + ex.getMessage());
        }

    }

}
