package task2;

public class TextComposite {
    public static void main(String[] args) {
        Component componentManager = new ComponentManager();

        componentManager.addComponent("\tSome sentence for paragraph to parse. Another sentence.\n\tSome paragraph.");

        Paragraph paragraph =  new Paragraph();
        paragraph.addComponent("\tWow sentence for paragraph to parse. Another sentence.\n\tWow paragraph.");

        componentManager.addComponent(paragraph);
        componentManager.write();
    }
}
