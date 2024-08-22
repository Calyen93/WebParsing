package com.example.webparser.analysis;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TextAnalyzer {

    // Metodo per analizzare il testo e contare le occorrenze delle parole
    public Map<String, Integer> analyzeText(String text) {
        // Rimuove la punteggiatura e converte tutto in minuscolo
        String[] words = text.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+");

        // Crea una mappa per contare le occorrenze delle parole
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }

    // Metodo per ordinare la mappa in base ai valori (frequenza delle parole) in ordine decrescente
    public Map<String, Integer> sortByFrequency(Map<String, Integer> wordCount) {
        return wordCount.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
