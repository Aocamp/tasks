package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Symbol implements Component {
    Object c;

    public Symbol(){

    }

    public Symbol(Object c){
        this.c = c;
    }

    @Override
    public void write() {
        String[] words = c.toString()
                .replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .replaceAll(" ", "")
                .replaceAll(",", "")
                .split("");

        System.out.println("Symbol: " + Arrays.toString(words));

    }

    @Override
    public void addComponent(Object component) {

    }

    @Override
    public Component getChild(int i) {
        return null;
    }
}
