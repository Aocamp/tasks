package task2;

public class TextComposite {
    public static void main(String[] args) {
        Word word = new Word();
        word.addComponent(new Symbol('h'));
        word.addComponent(new Symbol('e'));
        word.addComponent(new Symbol('l'));
        word.addComponent(new Symbol('l'));
        word.addComponent(new Symbol(' '));

        Word word1 = new Word();
        word1.addComponent(new Symbol('b'));
        word1.addComponent(new Symbol('o'));
        word1.addComponent(new Symbol('i'));
        word1.addComponent(new Symbol('i'));
        word1.addComponent(new Symbol('.'));

        Sentence sentence = new Sentence();
        sentence.addComponent(word);
        sentence.addComponent(word1);

        Paragraph paragraph = new Paragraph();
        paragraph.addComponent(sentence);

        ComponentManager componentManager = new ComponentManager();
        componentManager.addComponent(paragraph);
        componentManager.showComponent();
    }
}
