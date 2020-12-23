import java.util.Scanner;

public class Test8 {
  static   Scanner read=new Scanner(System.in);
    public static void main(String[] args) {

    }

    static boolean checkSum(int a, int b) {
        int sum = a + b;
        if (sum > 10 && sum <= 20) return true;
        return false;
        }
        static void checkYear(){
            System.out.println("Insert the year:");
            int year=read.nextInt();
        if(year%4==0 || year%100!=0) System.out.println();
        }
    }

