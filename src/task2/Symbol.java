package task2;

public class Symbol implements Component {
    private char c;
    public Symbol(char c){
        this.c = c;
    }

    @Override
    public void showComponent() {
        System.out.print(c);
    }

    @Override
    public void addComponent(Component component) {

    }


}
