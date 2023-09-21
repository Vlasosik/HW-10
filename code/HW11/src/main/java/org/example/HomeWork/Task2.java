package org.example.HomeWork;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<String> userList = Arrays.asList("1. Dima", "2. Oleksandr", "3. Petro", " 4. Ivan", "5. Mykola");
        String result = userList.stream()
                .map(String::toUpperCase)
                .sorted(Collections.reverseOrder())
                        .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
