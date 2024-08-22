package com.example.webparser.parser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

public class WebPageParserTest {

    @Test
    public void testGetPageContent() {
        WebPageParser parser = new WebPageParser();
        String url = "https://www.example.com";
        try {
            String content = parser.getPageContent(url);
            assertNotNull(content, "Il contenuto della pagina non dovrebbe essere nullo.");
            assertFalse(content.isEmpty(), "Il contenuto della pagina non dovrebbe essere vuoto.");
        } catch (IOException e) {
            fail("Si è verificato un errore durante il parsing della pagina web: " + e.getMessage());
        }
    }
}