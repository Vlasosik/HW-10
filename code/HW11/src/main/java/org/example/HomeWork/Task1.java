package org.example.HomeWork;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
//        List<String> userList = Arrays.asList("1. Dima", "2. Oleksandr", "3. Petro", " 4. Ivan", "5. Mykola");
//        List<String> collect = Collections.singletonList(IntStream
//                .range(0, userList.size())
//                .filter(i -> i % 2 == 0)
//                .mapToObj(userList::get)
//                .collect(Collectors.joining(", ")));
//        System.out.println(collect);

        List<String> userList1 = Arrays.asList("1. Dima", "2. Oleksandr", "3. Petro", " 4. Ivan", "5. Mykola");
        String result = userList1.stream()
                .filter(i -> {
                    int index = Integer.parseInt(i.split("\\.")[0].trim());
                    return index % 2 == 1;
                })
                .collect(Collectors.joining(", "));
        System.out.println(result);


    }
}
