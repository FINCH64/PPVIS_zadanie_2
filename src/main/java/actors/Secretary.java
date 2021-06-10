package actors;

import domains.Document;
import domains.catalog.Catalog;

import java.util.concurrent.atomic.AtomicBoolean;

public class Secretary {

    private Catalog mainCatalog;

    public Secretary(Catalog mainCatalog) {
        this.mainCatalog = mainCatalog;
    }

    public void addDocumentToCatalog(Catalog catalog, Document document) {
        catalog.addDocument(document);
    }

    public Document findDocumentByAuthor(String author) {
        Catalog catalogWithDocument = findDocumentCatalogByAuthor(author, mainCatalog);
        if (catalogWithDocument == null) {
            throw new IllegalArgumentException("Document doesn't exists");
        } else {
            for (Document d : catalogWithDocument.getDocuments()) {
                if(d.getAuthor().equals(author)) {
                    return d;
                }
            }
        }
       return null;
    }

    private Catalog findDocumentCatalogByAuthor(String author, Catalog currCatalog) {
        AtomicBoolean isFind = new AtomicBoolean(false);
        currCatalog.getDocuments().forEach(d -> {
            if(d.getAuthor().equals(author)) {
                isFind.set(true);
            }
        });

        if(isFind.get()) {
            return currCatalog;
        } else {
            for (Catalog c : currCatalog.getSubCatalogs()) {
                return findDocumentCatalogByAuthor(author, c);
            }
        }
        return null;
    }

    public Document findDocumentByHeader(String header) {
        Catalog catalogWithDocument = findDocumentCatalogByHeader(header, mainCatalog);
        if (catalogWithDocument == null) {
            throw new IllegalArgumentException("Document doesn't exists");
        } else {
            for (Document d : catalogWithDocument.getDocuments()) {
                if(d.getHeader().equals(header)) {
                    return d;
                }
            }
        }
        return null;
    }

    private Catalog findDocumentCatalogByHeader(String header, Catalog currCatalog) {
        AtomicBoolean isFind = new AtomicBoolean(false);
        currCatalog.getDocuments().forEach(d -> {
            if(d.getHeader().equals(header)) {
                isFind.set(true);
            }
        });

        if(isFind.get()) {
            return currCatalog;
        } else {
            for (Catalog c : currCatalog.getSubCatalogs()) {
                return findDocumentCatalogByAuthor(header, c);
            }
        }
        return null;
    }



}
