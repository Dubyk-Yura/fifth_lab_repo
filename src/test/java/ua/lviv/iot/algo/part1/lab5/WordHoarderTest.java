package ua.lviv.iot.algo.part1.lab5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WordHoarderTest {
    WordHoarder testWords;
    @BeforeEach
    void setUp() {
         testWords = new WordHoarder();
    }

    @Test
    public void testCapitalizedWords() {
        String sentence = "HELlo friend hello again.";
        int numOfSameWords = 2;
        Assertions.assertEquals("hello ",testWords.printAllWordsWhichRepeatMoreThan(sentence,numOfSameWords));
    }

    @Test
    public void testWordsWithDifferentPunctuationMarks() {
        String sentence = "hello, friend hello! my dear friend. again";
        int numOfSameWords = 2;
        Assertions.assertEquals("friend hello ",testWords.printAllWordsWhichRepeatMoreThan(sentence,numOfSameWords));
    }

    @Test
    public void testDifferentNumOfSameWords() {
        String sentence = "hi, Hi, HI/ hi! hI? hi";
        int numOfSameWords = 6;
        Assertions.assertEquals("hi ",testWords.printAllWordsWhichRepeatMoreThan(sentence,numOfSameWords));
    }

    @Test
    public void testWithoutSameWords() {
        String sentence = "hi, glad to see you";
        int numOfSameWords = 2;
        Assertions.assertEquals("",testWords.printAllWordsWhichRepeatMoreThan(sentence,numOfSameWords));
    }

    @Test
    public void testWordsWithNumbers() {
        String sentence = "hi, gl1d to see6 1you see1 gl1d 4you";
        int numOfSameWords = 2;
        Assertions.assertEquals("gl1d ",testWords.printAllWordsWhichRepeatMoreThan(sentence,numOfSameWords));
    }
}


