package task2;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements Component{
    List<Component> components = new ArrayList<>();

    @Override
    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public void showComponent() {
        for (Component component : components) {
            System.out.print("  ");
            component.showComponent();
        }
    }
}
