package ru.npsolonenko;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProtocolFormatter {

    private static final String HTML = "src/main/files/protocol.html";

    private List<ProtocolEntry> entries = new ArrayList<>();
    private String title;

    public ProtocolFormatter(String title) {
        this.title = title;
    }

    public void addEntry(String timestamp, String level, String message) {
        entries.add(new ProtocolEntry(timestamp, level, message));
    }

    public void generateHtmlFile(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("<!DOCTYPE html>");
            writer.println("<html lang=\"ru\">");
            writer.println("<head>");
            writer.println("    <meta charset=\"UTF-8\">");
            writer.println("    <title>" + escapeHtml(title) + "</title>");
            writer.println("    <style>");
            writer.println("        body { font-family: Arial, sans-serif; line-height: 1.6; margin: 20px; }");
            writer.println("        h1 { color: #333; }");
            writer.println("        .entry { margin-bottom: 10px; padding: 8px; border-radius: 4px; }");
            writer.println("        .timestamp { color: #666; font-size: 0.9em; }");
            writer.println("        .level-info { background-color: #e6f7ff; }");
            writer.println("        .level-warning { background-color: #fff7e6; }");
            writer.println("        .level-error { background-color: #ffe6e6; }");
            writer.println("        .message { margin-top: 4px; }");
            writer.println("    </style>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("    <h1>" + escapeHtml(title) + "</h1>");
            writer.println("    <p>Сгенерировано: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "</p>");
            writer.println("    <div class=\"entries\">");

            for (ProtocolEntry entry : entries) {
                String levelClass = "level-" + entry.level.toLowerCase();
                writer.println("        <div class=\"entry " + levelClass + "\">");
                writer.println("            <div class=\"timestamp\">" + escapeHtml(entry.timestamp) + "</div>");
                writer.println("            <div class=\"level\">" + escapeHtml(entry.level) + "</div>");
                writer.println("            <div class=\"message\">" + escapeHtml(entry.message) + "</div>");
                writer.println("        </div>");
            }

            writer.println("    </div>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }

    private String escapeHtml(String input) {
        if (input == null)
            return "";
        return input.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }

    private static class ProtocolEntry {
        String timestamp;
        String level;
        String message;

        ProtocolEntry(String timestamp, String level, String message) {
            this.timestamp = timestamp;
            this.level = level;
            this.message = message;
        }
    }

    public static void main(String[] args) {
        ProtocolFormatter formatter = new ProtocolFormatter("System operation protocol");

        formatter.addEntry("2023-05-15 10:00:00", "INFO", "Система запущена");
        formatter.addEntry("2023-05-15 10:05:23", "WARNING", "Недостаточно памяти");
        formatter.addEntry("2023-05-15 10:07:45", "ERROR", "Ошибка подключения к БД");
        formatter.addEntry("2023-05-15 10:10:12", "INFO", "Попытка переподключения");
        formatter.addEntry("2023-05-15 10:12:34", "INFO", "Подключение восстановлено");

        try {
            formatter.generateHtmlFile(HTML);
            System.out.println("The HTML file of the protocol has been successfully created!");
        }
        catch (IOException e) {
            System.err.println("Error when creating an HTML file: " + e.getMessage());
        }
    }
}