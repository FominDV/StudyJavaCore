public class Test6 {
    public static void main(String[] args) {
int a=6;
        new Thread(() -> { System.out.println(a); }).start();
    }

}
