package main.java.com.example.scraper;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String url = JOptionPane.showInputDialog("Digite a URL: ", "https://");

        int option;
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(
                    "Escolha uma opção: " +
                            "\n1 - Mudar site" +
                            "\n2 - Buscar links" +
                            "\n3 - Buscar parágrafos" +
                            "\n9 - Sair"));
            handleOption(option, url);
        } while (option != 9);
    }

    private static void handleOption(int option, String url) {
        switch (option) {
            case 1:
                url = JOptionPane.showInputDialog("Digite a URL: ", url);
                break;
            case 2:
                fetchAndPrintLinks(url);
                break;
            case 3:
                fetchAndPrintParagraphs(url);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private static void fetchAndPrintLinks(String url) {
        System.out.println("Buscando links...");
        String subject = JOptionPane.showInputDialog(
                "Digite o assunto: \nCaso queira buscar todos os links, deixe em branco");
        Scraper.printLinks(url, subject);
    }
    private static void fetchAndPrintParagraphs(String url) {
        System.out.println("Buscando parágrafos...");
        Scraper.printParagraphs(url);
    }
}