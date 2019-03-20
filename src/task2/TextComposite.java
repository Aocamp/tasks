package task2;

public class TextComposite {
    public static void main(String[] args) {
        Symbol symbol = new Symbol('h');
        Symbol symbol1 = new Symbol('e');
        Symbol symbol2 = new Symbol('l');
        Symbol symbol3 = new Symbol('l');
        Symbol symbol0 = new Symbol(' ');
        Word word = new Word();
        word.addComponent(symbol);
        word.addComponent(symbol1);
        word.addComponent(symbol2);
        word.addComponent(symbol3);
        word.addComponent(symbol0);
        Symbol symbol4 = new Symbol('b');
        Symbol symbol5 = new Symbol('o');
        Symbol symbol6 = new Symbol('i');
        Symbol symbol7 = new Symbol('i');
        Symbol symbol8 = new Symbol('.');
        Word word1 = new Word();
        word.addComponent(symbol4);
        word.addComponent(symbol5);
        word.addComponent(symbol6);
        word.addComponent(symbol7);
        word.addComponent(symbol8);
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
