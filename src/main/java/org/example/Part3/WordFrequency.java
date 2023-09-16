package org.example.Part3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class WordFrequency {
    public static final String ABSOLUTE_PATH = "src/main/java/org/example/HomeWork/Part3/words.txt";

    public static void main(String[] args) {
        String filePath = ABSOLUTE_PATH;
        Map<String, Integer> wordFrequency = countWord(filePath);
        List<Map.Entry<String, Integer>> sorted = entriesSortedByValues(wordFrequency);

        for (Map.Entry<String, Integer> sort : sorted) {
            System.out.println(sort.getKey() + " " + sort.getValue());
        }
    }
    private static Map<String, Integer> countWord(String filePath) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Scanner scanner = new Scanner(line);
                while (scanner.hasNextLine()) {
                    String word = scanner.next();
                    if (!word.isEmpty()) {
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return wordFrequency;
    }
    static <K, V extends Comparable<? super V>> List<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
        List<Map.Entry<K, V>> sortedEntries = new ArrayList<>(map.entrySet());
        Collections.sort(sortedEntries, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });
        return sortedEntries;
    }
}
