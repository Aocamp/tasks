package task2;

public class TextComposite {
    public static void main(String[] args) {
        ComponentManager componentManager = new ComponentManager();
        componentManager.addComponent(new Paragraph(
                new Sentence(new Word("hleo"),new Symbol(' '), new Word("wordl"), new Symbol('!'))));
        componentManager.addComponent(new Paragraph(
                new Sentence(new Word("hleo"),new Symbol(' '), new Word("wordl"), new Symbol('!'))));
        componentManager.write();
    }
}
