package com.example.webparser.main;

import com.example.webparser.parser.WebPageParser;
import com.example.webparser.analysis.TextAnalyzer;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        WebPageParser parser = new WebPageParser();
        TextAnalyzer analyzer = new TextAnalyzer();

        try {
            // Esempio di URL da analizzare
            String url = "https://www.example.com";

            // Parsing della pagina web
            String content = parser.getPageContent(url);
            System.out.println("Contenuto della pagina:");
            System.out.println(content);

            // Analisi del testo
            Map<String, Integer> wordCount = analyzer.analyzeText(content);

            // Ordinamento delle parole per frequenza
            Map<String, Integer> sortedWordCount = analyzer.sortByFrequency(wordCount);

            // Visualizzazione delle prime 10 parole più frequenti
            sortedWordCount.entrySet()
                    .stream()
                    .limit(10)
                    .forEach(entry ->
                            System.out.println(entry.getKey() + ": " + entry.getValue())
                    );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
