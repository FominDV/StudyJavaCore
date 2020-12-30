import java.util.Arrays;

public class TestForJava1 {
    public static void main(String[] args) {
        int[][] arr = new int[10][10];
        for (int[] e : arr) {
            for (int e2 : e) e[e2] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - 1 - i] = 1;
        }
        for (int[] e : arr) System.out.println(Arrays.toString(e));
        ///////////////////////////////////////////////////////////////////////
        int a = 34;
        check(a);
        int n = getNumber(a);
        System.out.println(n);
        getNumber(12);
        float f = getFloat(1, 2, 3);
        System.out.println(f);
        //////////////////////////////
        int[] intArr = {1, 0, 0, 1, 1};
        int[] gog = {1, 0, 0, 1, 1, 0, 1, 0};
        refactorBinary(intArr);
        refactorBinary(gog);
        System.out.println(Arrays.toString(intArr));
        System.out.println(Arrays.toString(gog));
        String s = "hotrfrscccc";
        System.out.println(s.matches("^(c)*"));
        System.out.println(Math.round(3.47));
        String ip = "255.6.2.133";
        System.out.println(ip.matches("(\\d{1,3}\\.){3}\\d{1,3}"));
    }

    static void check(int number) {
        if (number > 10 && number <= 20) System.out.println("Ok");
        else System.out.println("Not ok");
    }

    static int getNumber(int a) {
        int b = a * 2;
        return b;
    }

    static float getFloat(int a, int b, int c) {
        return a + b + c;
    }

    static void refactorBinary(int[] t) {
        for (int i = 0; i < t.length; i = i + 1) {
            t[i] = 1 - t[i];
        }
    }
}
