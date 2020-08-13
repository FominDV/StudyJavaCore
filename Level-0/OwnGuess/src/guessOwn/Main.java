package guessOwn;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int attempt = 1;
        int range = 0;
        System.out.println("Your task is to guess the number");
        while(attempt > 0) {
            attempt += range/10+5;
            System.out.println("Do you want continue? \n 1-YES  0-NO");
            int task = scn.nextInt();
            if(task == 1) {
                range+=10;
                attempt = playerLevel(range, attempt);
            }else{
                break;
            }
        }
        System.out.println("GAME OVER\nTotal:\nYou finished " + (range/10) + " levels");
        scn.close();
    }
    private static Scanner scn = new Scanner(System.in);

    private static int playerLevel (int range, int attempt) {
        System.out.println("Now you have " + attempt + " attemps");
        int number = (int)(Math.random()*range);
        System.out.println("Start level № " + (range/10));
        while(attempt>0){
            System.out.println("Enter your number from 0 to " + (range-1));
            int inputNumber = scn.nextInt();
            if(inputNumber == number) {
                System.out.println("You WIN! It is really " + number + "\nGood job! You have earned " + (range/10+4) + " more attempts!");
                break;
            } else if(inputNumber > number) {
                attempt --;
                System.out.println("Hidden number is less than " + inputNumber + "\n You have " + attempt + " attempts left");
            } else {
                attempt --;
                System.out.println("Hidden number is greater than " + inputNumber + "\n You have " + attempt + " attempts left");
            }
        }
        return attempt;
    }
}