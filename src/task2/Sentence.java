package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sentence implements Component{
    List<Component> components = new ArrayList<>();

    public Sentence(Component... component) {
        components.addAll(Arrays.asList(component));
    }

    public void addComponent(Component... component) {
        components.addAll(Arrays.asList(component));
    }

    public void removeComponent(Component component){
        components.remove(component);
    }

    @Override
    public void write() {
        for (Component component : components) {
            component.write();
        }
    }
}
