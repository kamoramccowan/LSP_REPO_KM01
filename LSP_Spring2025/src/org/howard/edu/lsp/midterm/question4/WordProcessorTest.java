package org.howard.edu.lsp.midterm.question4;

import java.util.List;

public class WordProcessorTest {
    public static void main(String[] args) {
        WordProcessor processor1 = new WordProcessor("The quick brown fox jumps over the lazy dog");
        WordProcessor processor2 = new WordProcessor("apple banana strawberry pineapple");
        WordProcessor processor3 = new WordProcessor("");

        // Test Cases
        List<String> longestWords1 = processor1.findLongestWords();
        List<String> longestWords2 = processor2.findLongestWords();
        List<String> longestWords3 = processor3.findLongestWords();

        System.out.println("Longest words in sentence 1: " + longestWords1); // ["jumps"]
        System.out.println("Longest words in sentence 2: " + longestWords2); // ["strawberry", "pineapple"]
        System.out.println("Longest words in sentence 3: " + longestWords3); // []
    }
}
