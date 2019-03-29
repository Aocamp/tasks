package task2;

public interface Component <T> {
    void write();
    void addComponent(T t);
    Component getChild(int i);
}
