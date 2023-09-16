package org.example.Part1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PhoneNumbersValidator {
    public static void main(String[] args) {
        File file = new File("src/main/java/org/example/HomeWork/Part1/file.txt");
        numberValidator(file);
    }
    private static void numberValidator(File file) {
        try(FileInputStream fileInputStream = new FileInputStream(file)){
            Scanner scanner = new Scanner(fileInputStream);
            Pattern pattern = Pattern.compile("\\(\\d{3}\\)\\s?\\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}");
            while (scanner.hasNext()){
                String fileLine = scanner.nextLine();
                Matcher matcher = pattern.matcher(fileLine);
                while (matcher.find()){
                    String phoneNumber = matcher.group();
                    System.out.println(phoneNumber);
                }
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
