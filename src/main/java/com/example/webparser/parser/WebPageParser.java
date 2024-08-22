package com.example.webparser.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WebPageParser {

    // Metodo per scaricare e restituire il contenuto testuale di una pagina web
    public String getPageContent(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        return document.text(); // Restituisce solo il testo della pagina senza HTML
    }
}
