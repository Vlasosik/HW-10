package org.example.HomeWork;

import java.util.stream.Stream;

public class Task4 {
    private static long a = 25214903917L;
    private static long c = 11L;
    private static long m = (2 ^ 48);
    private static long seed = 0L;

    public static void main(String[] args) {
        Stream<Long> inputRandomNumber = generateRandomNumbers(a, c, m, seed);
        inputRandomNumber.limit(100)
                .forEach(System.out::println);
    }

    private static Stream<Long> generateRandomNumbers(long a, long c, long m, long seed) {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }
}
