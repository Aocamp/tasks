package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word implements Component {
    String word;

    public Word(String word){
        this.word = word;
    }

    @Override
    public void write() {
        System.out.print(word);
    }
}
