package actors;

import domains.Document;
import domains.catalog.Catalog;
import java.time.*;

public class Writer {

    private final String name;

    public Writer(String name) {
        this.name = name;
    }

    public void createDocument(String header, String text, Catalog catalog) {
        LocalDateTime date = LocalDateTime.now();
        Document document = new Document(header, this.name, text, date);
        catalog.addDocument(document);
    }

    public void changeDocument(Document document, String header, String text) {
        document.setHeader(header);
        document.setText(text);
    }

    public void changeTextOfDocument(Document document, String text) {
        document.setText(text);
    }

    public void changeHeaderOfDocument(Document document, String header) {
        document.setHeader(header);

    }

    public String getName() {
        return name;
    }
}
