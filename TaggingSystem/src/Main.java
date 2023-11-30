import java.util.List;
import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        TaggingSystem taggingSystem = TaggingSystem.getInstance();
        Tag tag = new Tag("Java");
        Tag tag2 = new Tag("C++");
        Document document = new Document("Shubham");
        Document document2 = new Document("Ayush");
        taggingSystem.addTag(document,tag);
        taggingSystem.addTag(document2,tag);
        taggingSystem.addTag(document,tag2);
        Set<Tag> st = taggingSystem.getDocumentTags(document);
        for (Tag t: st) {
            System.out.println(t.getName());
        }
        List<Document> lst = taggingSystem.getAllDocuments(tag);
        for (Document d: lst) {
            System.out.println(d.getData());
        }
    }
}