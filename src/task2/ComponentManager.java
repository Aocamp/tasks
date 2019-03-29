package task2;

import java.util.ArrayList;
import java.util.List;

public class ComponentManager implements Component{
    private List<Component> components = new ArrayList<>();

    @Override
    public void addComponent(Object component) {
        if (component instanceof String){
            Paragraph paragraph = new Paragraph();
            paragraph.addComponent(component);
            components.add(paragraph);
        }else {
            components.add((Component) component);
        }
    }

    public void removeComponent(Component component){
        components.remove(component);
    }

    @Override
    public Component getChild(int i){
        return components.get(i);
    }

    @Override
    public void write() {
        for (Component component : components) {
            component.write();
        }
    }
}
