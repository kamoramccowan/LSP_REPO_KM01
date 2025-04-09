package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

// WordProcessor class implementation
public class WordProcessor {
    private String sentence;

    // Constructor
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    // Method to find all longest words in the sentence
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();
        if (sentence == null || sentence.trim().isEmpty()) {
            return longestWords;
        }
        
        String[] words = sentence.split("\\s+"); // Split on one or more spaces
        int maxLength = 0;
        
        for (String word : words) {
            int length = word.length();
            if (length > maxLength) {
                maxLength = length;
                longestWords.clear();
                longestWords.add(word);
            } else if (length == maxLength) {
                longestWords.add(word);
            }
        }
        
        return longestWords;
    }
}

