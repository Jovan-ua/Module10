package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import java.util.Map;

public class Task3 {
    public static void main(String[] args) {
        String fileName = "src/main/resources/Task3/words.txt";
        Map<String, Integer> wordFrequencyMap = countWordFrequency(fileName);
        printWordFrequency(wordFrequencyMap);
    }

    public static Map<String, Integer> countWordFrequency(String fileName) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase(); // Приводим слова к нижнему регистру
                    if (!word.isEmpty()) {
                        wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Сортировка по частоте (от наибольшей к наименьшей)
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordFrequencyMap.entrySet());
        sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Создаем новую LinkedHashMap для сохранения упорядоченных результатов
        LinkedHashMap<String, Integer> sortedWordFrequencyMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : sortedList) {
            sortedWordFrequencyMap.put(entry.getKey(), entry.getValue());
        }

        return sortedWordFrequencyMap;
    }

    public static void printWordFrequency(Map<String, Integer> wordFrequencyMap) {
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
