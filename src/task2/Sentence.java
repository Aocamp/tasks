package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Sentence implements Component{
    private List<Component> components = new ArrayList<>();

    @Override
    public void addComponent(Object component) {
        Word word = new Word();
        word.addComponent(getSentence(component));

        components.add(word);
    }

    @Override
    public Component getChild(int i) {
        return components.get(i);
    }

    public void removeComponent(Component component){
        components.remove(component);
    }

    private String getSentence(Object component){
        String[] s = component
                .toString()
                .replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .split("\\s*[.,?] ");

        for (String sentence : s) {
            System.out.println("Sentence: " + sentence);
        }

        return Arrays.toString(s);
    }

    @Override
    public void write() {
        for (Component component : components) {
            component.write();
        }
    }
}
