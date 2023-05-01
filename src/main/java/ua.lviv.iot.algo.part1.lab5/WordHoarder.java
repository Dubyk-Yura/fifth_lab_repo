package ua.lviv.iot.algo.part1.lab5;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordHoarder {
    private static Pattern REPEAT_COUNT_PATTERN = Pattern.compile("\\b(\\w+)\\b(?=.*\\b\\1\\b)");
    private StringBuilder modifierText;

    public String printAllWordsWhichRepeatMoreThan(String text, int index) {
        modifierText = new StringBuilder();
        Matcher matcher = REPEAT_COUNT_PATTERN.matcher(text.toLowerCase());
        Map<String, Integer> wordCountMap = new HashMap<>();

        while (matcher.find()) {
            String word = matcher.group(1);
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 1) + 1);
        }
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() >= index) {
                modifierText.append(entry.getKey()).append(" ");
            }
        }
        return modifierText.toString();
    }


    public static void main(String[] args) {
        System.out.println("Enter how many times(or more) the word should be repeated : ");
        Scanner indexScanner = new Scanner(System.in, StandardCharsets.UTF_8);
        final int index = indexScanner.nextInt();
        indexScanner.nextLine();
        System.out.println("Enter a sentence: ");
        Scanner sentanceScanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String sentence = sentanceScanner.nextLine();
        WordHoarder remover = new WordHoarder();
        System.out.println("Words what repeat: ");
        if (!remover.printAllWordsWhichRepeatMoreThan(sentence, index).isEmpty()) {
            System.out.println(remover.printAllWordsWhichRepeatMoreThan(sentence, index));
        } else {
            System.out.println("No word in the text is repeated a given number of times");
        }
        indexScanner.close();
        sentanceScanner.close();
    }
}
