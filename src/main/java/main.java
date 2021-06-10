import actors.*;
import domains.*;
import domains.catalog.Catalog;
import domains.catalog.MainCatalog;
import domains.catalog.SubCatalog;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class main {
    public static void main(String[] args) {
        MainCatalog maxRoot = MainCatalog.createMainCatalog("rootCat");
        Writer writer = new Writer("Alex");
        writer.createDocument("book","skazka",maxRoot);
        Set<Document> doc = maxRoot.getDocuments();
        for(Document a : doc) {
            writer.changeHeaderOfDocument(a,"book2");
            writer.changeTextOfDocument(a,"some info");
        };
        writer.createDocument("paper piece", "some info again", maxRoot);
        writer.createDocument("note", "some note", maxRoot);
        Secretary secr = new Secretary(maxRoot);
        secr.addDocumentToCatalog(maxRoot,new Document("paper","secr","news", LocalDateTime.now()));
        Admin adm = new Admin(maxRoot);
        adm.createCatalog(maxRoot,"subCat");
        SubCatalog newSubCat = new SubCatalog("newSub",maxRoot);
        secr.addDocumentToCatalog(maxRoot,new Document("metodology","secr","some advices", LocalDateTime.now()));
        Document result = secr.findDocumentByAuthor("secr");
        adm.removeDocument(result);
        result = secr.findDocumentByHeader("book2");
        adm.moveDocument(result,newSubCat);
    }
}
