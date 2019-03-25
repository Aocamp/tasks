package task1;

import javax.management.ObjectName;
import java.util.*;

public class Task {
    public static void main(String[] args) {
        Task task = new Task();
        task.justDoIt();
    }

    private boolean exit = false;

    private void justDoIt(){
        while (!exit){
        System.out.println("«1. Для создания массива из нечетных числе нажмите 1».\n" +
                "«2. Для создания массива из чисел Фибоначчи нажмите 2»\n" +
                "«4. Для выхода из приложения нажмите 4.»\n");
        Scanner scan = new Scanner(System.in);
        System.out.print("number: ");
        int number = scan.nextInt();
        doIt(number);
        }
    }

    private void doIt(int number){
        switch (number){
            case 1: array();
                break;
            case 2: fibonachi();
                break;
            case 3: doubleArray();
                break;
            case 4:
                exit = true;
                System.out.println("exit");
                break;
        }
    }

    private void array(){
        int[] cats = new int[50];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (i%2 !=0){
                list.add(i);
            }
        }
        for (int a = 0; a < list.size(); a++){
            cats[a] = list.get(a);
        }
        System.out.println(Arrays.toString(cats));
        System.out.println();
    }

    private void fibonachi(){
        int[] fibo = new int[20];
        List<Integer> list = new ArrayList<>();
        int number1 = 1;
        int number2 = 1;
        for (int i = 0; i < fibo.length; i++){
            int number3 = number1 + number2;
            list.add(number3);
            number1 = number2;
            number2 = number3;
        }
        for (int a = 0; a < list.size(); a++){
            fibo[a] = list.get(a);
        }
        System.out.println(Arrays.toString(fibo));
        System.out.println();
    }

    private void doubleArray(){
        int row = 8;
        int col = 5;
        int[][] array = new int[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                array[i][j]=(int)(Math.random()*90)+10;
            }
        }

        int[] anArray = new int[40];
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                anArray[count++] = array[i][j];
            }
        }

        Arrays.sort(anArray);

        count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                array[i][j] = anArray[count++];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }
}
