package lesson3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Your task is to guess the number\nEnter count of numbers");
        int range = scn.nextInt();
        int number = (int)(Math.random()*range);
        while(true){
            System.out.println("Enter your number from 0 to " + (range-1));
            int inputNumber = scn.nextInt();
            if(inputNumber == number) {
                System.out.println("You WIN! It is really " + number);
                break;
            } else if(inputNumber > number) {
                System.out.println("Hidden number is less than " + inputNumber);
            } else {
                System.out.println("Hidden number is greater than " + inputNumber);
            }

        }
        scn.close();
    }
}
