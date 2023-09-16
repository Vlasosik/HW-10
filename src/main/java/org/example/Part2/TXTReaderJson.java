package org.example.Part2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TXTReaderJson {
    public static void main(String[] args) {
        String inputFile = "src/main/java/org/example/HomeWork/Part2/file.txt";
        String outputFile = "src/main/java/org/example/HomeWork/Part2/user.json";
        List<User> userList = readTxtFile(inputFile);
        writeJsonFile(outputFile, userList);

    }

    // Метод для читання файлу та конвертації його в список об'єктів User
    private static List<User> readTxtFile(String filePath) {
        List<User> userList = new ArrayList<>();
        File file = new File(filePath);
        try(Scanner scanner = new Scanner(new FileReader(file))) {
            String[] headers = null;
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] data = line.split(" ");
                if (headers == null){
                    headers = data;
                }else if (data.length==headers.length ){
                    String name = data[0];
                    int age = Integer.parseInt(data[1]);
                    userList.add(new User(name, age));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }


    // Метод для запису списку користувачів у файл JSON
    private static void writeJsonFile(String filePath, List<User> userList) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(fileWriter, userList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
