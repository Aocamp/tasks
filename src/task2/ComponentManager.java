package task2;

import java.util.ArrayList;
import java.util.List;

public class ComponentManager implements Component{
    List<Component> components = new ArrayList<>();

    public void addComponent(Component component) {
        components.add(component);
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
