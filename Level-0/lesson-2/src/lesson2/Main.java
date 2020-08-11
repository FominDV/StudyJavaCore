package lesson2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Enter the operation");
        System.out.println("1 - Addition");
        System.out.println("2 - Subtraction");
        System.out.println("3 - Multiplication");
        System.out.println("4 - Division");
        Scanner scan = new Scanner(System.in);
        int operation = scan.nextInt();
        System.out.println("Enter the first number");
        double FirstNan = scan.nextInt();
        System.out.println("Enter second number");
        double SecondNan = scan.nextInt();
        double result;
        String text = "";
        if (operation == 1) {
            result = FirstNan + SecondNan;
            text = "addition";
        } else if (operation == 2) {
            result = FirstNan - SecondNan;
            text = "subtraction";
        } else if(operation == 3) {
            result = FirstNan * SecondNan;
            text = "multiplication";
        } else {
            result = FirstNan/SecondNan;
            text = "division";
        }
        DecimalFormat reduction = new DecimalFormat("#.00");
        System.out.println("Result of "+text + " = " + reduction.format(result));
    }
}
