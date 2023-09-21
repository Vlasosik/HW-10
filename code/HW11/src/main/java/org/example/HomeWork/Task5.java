package org.example.HomeWork;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task5 {
    public static void main(String[] args) {
        Stream<Integer> first = Stream.of(1,2,3,4,45);
        Stream<Integer> second = Stream.of(4,2,54,32,412,3);
        zip(first, second).forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> list1 = first.toList();
        List<T> list2 = second.toList();
        int min = Math.min(list1.size(), list2.size());
        Stream<T> zippedStream = IntStream.range(0, min)
                .mapToObj(i -> {
                    T elementFirst = list1.get(i);
                    T elementSecond = list2.get(i);
                    return Stream.of(elementFirst, elementSecond);
                })
                .flatMap(Function.identity());
        return zippedStream;
    }
}
