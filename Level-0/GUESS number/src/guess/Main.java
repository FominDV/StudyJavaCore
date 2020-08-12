package guess;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Your task is to guess the number");
        for (int i = 10; i <=30; i += 10){
            int number = (int)(Math.random()*i);
            playerLevel(i, number);
        }
        scn.close();
    }
    private static Scanner scn = new Scanner(System.in);
    private static void playerLevel (int range, int number) {
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
    }
}
