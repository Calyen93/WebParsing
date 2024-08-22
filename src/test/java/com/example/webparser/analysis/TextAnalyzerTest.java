package com.example.webparser.analysis;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

public class TextAnalyzerTest {

    @Test
    public void testAnalyzeText() {
        TextAnalyzer analyzer = new TextAnalyzer();
        String text = "hello world hello";

        Map<String, Integer> wordCount = analyzer.analyzeText(text);
        assertEquals(2, wordCount.get("hello"));
        assertEquals(1, wordCount.get("world"));
    }

    @Test
    public void testSortByFrequency() {
        TextAnalyzer analyzer = new TextAnalyzer();
        String text = "apple apple orange banana banana banana";

        Map<String, Integer> wordCount = analyzer.analyzeText(text);
        Map<String, Integer> sortedWordCount = analyzer.sortByFrequency(wordCount);

        String[] expectedOrder = {"banana", "apple", "orange"};
        int i = 0;
        for (String word : sortedWordCount.keySet()) {
            assertEquals(expectedOrder[i], word);
            i++;
        }
    }
}