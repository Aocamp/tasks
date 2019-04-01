package task2;

public class TextComposite {
    public static void main(String[] args) {
        String text = "\tWow sentence for paragraph to parse. Another sentence.\n\tWow paragraph.";

        Component componentManager = new ComponentManager();

        componentManager.addComponent(text);

//        Paragraph paragraph =  new Paragraph();
//        paragraph.addComponent(text);
//
//        componentManager.addComponent(paragraph);

        componentManager.write();
    }
}
