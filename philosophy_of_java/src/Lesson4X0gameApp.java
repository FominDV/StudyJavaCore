import java.util.Scanner;

public class Lesson4X0gameApp {
   static String[] trace;
   static int countOfPoints,countOfTraces;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        countOfPoints =scanner.nextInt();
        int[] trace2=new int[countOfPoints];
        trace=scanner.nextLine().split(" ");
        for (int i = 0; i < countOfPoints; i++) {
            trace2[i]=Integer.parseInt(trace[i]);
        }
        countOfTraces=scanner.nextInt();
        int[][] vector=new int[countOfTraces][2];
        for (int i = 0; i < countOfTraces; i++) {
            String[] a=scanner.nextLine().split(" ");
            vector[i][0]=Integer.parseInt(a[0]);
            vector[i][1]=Integer.parseInt(a[1]);
        }



    }
}



