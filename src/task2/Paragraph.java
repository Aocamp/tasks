package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Paragraph implements Component{
    private List<Component> components = new ArrayList<>();

    public void addComponent(Object component) {
        Sentence sentence = new Sentence();
        sentence.addComponent(getParagraph(component));

        components.add(sentence);
    }

    @Override
    public Component getChild(int i) {
        return components.get(i);
    }

    public void removeComponent(Component component){
        components.remove(component);
    }

    private String getParagraph(Object component){
        String[] s = component.toString().trim().split("\\n\\s");

        for (String paragraph : s) {
            System.out.println("Paragraph: " + paragraph);
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
