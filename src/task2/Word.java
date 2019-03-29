package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word implements Component {
    private List<Component> components = new ArrayList<>();

    @Override
    public void addComponent(Object component) {
        Symbol symbol = new Symbol(getWord(component));

        components.add(symbol);
    }

    @Override
    public Component getChild(int i) {
        return components.get(i);
    }

    public void removeComponent(Component component){
        components.remove(component);
    }

    private String getWord(Object component){
        String[] s = component.toString()
                .replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .replaceAll(",", "")
                .split("\\s");

        for (String sentence : s) {
            System.out.println("Words: " + sentence);
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
