package domains;

import domains.catalog.Catalog;

import java.util.Objects;
import java.time.*;

public class Document {
    private String header;
    private final LocalDateTime creationDate;
    private final String author;
    private String text;
    private Catalog currCatalog;

    public Document(String header, String author, String text, LocalDateTime date) {
        this.header = header;
        this.creationDate = date;
        this.author = author;
        this.text = text;
        this.currCatalog = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return header.equals(document.header);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header);
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Catalog getCurrCatalog() {
        return currCatalog;
    }

    public void setCurrCatalog(Catalog currCatalog) {
        this.currCatalog = currCatalog;
    }
}
