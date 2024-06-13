package main.java.com.example.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Scraper {

    public static void printLinks(String url, String subject) {
        try {
            Document document = Jsoup.connect(url).get();
            Elements links = document.select("a[href]");
            links.forEach(link -> {
                if (subject.isBlank() || link.text().contains(subject)) {
                    System.out.println(link.attr("href") + " - " + link.text());
                }
            });
        } catch (IOException e) {
            handleError(e);
        }
    }

    public static void printParagraphs(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            Elements paragraphs = document.select("p");
            paragraphs.forEach(paragraph -> System.out.println(paragraph.text()));
        } catch (IOException e) {
            handleError(e);
        }
    }

    private static void handleError(IOException e) {
        System.err.println("Erro ao conectar com a URL: " + e.getMessage());
        throw new RuntimeException(e);
    }
}
