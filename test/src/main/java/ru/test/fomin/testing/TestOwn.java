package ru.test.fomin.testing;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class TestOwn {
    public static void main(String[] args) {
        int[] first = {10, 20, 30, 40};
        int[] second = new int[6];
        second = first;
        System.out.println(first[2]);

        int[] arr = {1, 2, 3, 4, 5, 6};
        for (int value : arr) {
            System.out.println(value);
        }
        int[][] arrDouble = new int[3][4];
        for (int i = 0; i < arrDouble.length; i++) {
            for (int j = 0; j < arrDouble[0].length; j++) {
                arrDouble[i][j] = i;
            }
        }
        for (int[] value1 : arrDouble) {
            for (int value2 : value1) {
                System.out.println(value2);
            }
        }
        if (Arrays.equals(first, second)) System.out.println("true");
        else
            System.out.println("false");
        System.out.println(second.length);
        System.out.println(Arrays.toString(second));
        System.out.println(Arrays.binarySearch(second, 25));
        String str = "comedy club";
        System.out.println("length = " + str.length());
        String[] parts = str.split(" ");
        System.out.println(Arrays.toString(parts));

        MyClass MyClass = new MyClass();
        ChildMyClass Child = new ChildMyClass();
        MyClass.showNumber();
        MyClass obj = new MyClass();
        obj.setNumber(7);
        obj.showNumber();
        MyClass.showNumber();
        Child.showNumber();
    }
}

class MyClass {
    static int number = 5;

    static void setNumber(int numberInput) {
        number = numberInput;
    }

    void showNumber() {
        System.out.println("Parent:" + number);
    }
}

class ChildMyClass extends MyClass {
    @Override
    void showNumber() {
        super.showNumber();
        System.out.println("Child:" + (number * 2));
    }
}
