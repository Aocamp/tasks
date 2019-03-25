package task2;

public class Symbol implements Component {
    char[] c;
    public Symbol(char... c){
        this.c = c;
    }

    @Override
    public void write() {
        System.out.print(c);
    }
}
