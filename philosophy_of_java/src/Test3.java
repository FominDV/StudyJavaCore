import java.nio.charset.StandardCharsets;

public class Test3 {
    public static void main(String[] args) {
class s implements Inter.A{

    @Override
    public void f() {
        System.out.println("A");
    }
}
new s().f();
Inter.A ai=new Inter().getAr();
ai.f();



        //a=7
        long a = 07777777777770L;
        System.out.println(Long.toOctalString(a));
        float f = 3.4e-2f;
        System.out.println("f= " + (f));
        int hex1 = 0xf1;
        int hex2 = 0xf0;
        System.out.println(Integer.toBinaryString(hex1 ^ hex2));
        System.out.println("hex1=" + Integer.toBinaryString(hex1));
        hex1 <<= 5;
        System.out.println("hex1=" + Integer.toBinaryString(hex1));
        double d = 0.59;
        int i = (int) Math.round(d);
        d = (double) i + 0.45;
        System.out.println(i);
        System.out.println(d);
        lab:
        for (int j = 0; j < 10; j++) {
            lab1:
            for (int jj = j + 1; jj < 11; jj++) {
                System.out.println("j=" + j);
                System.out.println("jj=" + jj);
                if (j == 5) {
                    System.out.println("break lab1");
                    continue lab1;
                }
                if (j == 7) {
                    break lab;
                }
            }
        }

        String s = new String(new byte[]{0, 65, 0, 66}, StandardCharsets.UTF_16);
        String as = "fa";
        as.toUpperCase();
        System.out.println(as);
        int[] arr = new int[10];
        int leng = arr.length;
        byte by = 127;
        by++;
        System.out.println(by);
        Cat cat1 = new Cat("1");
        Cat cat2 = new Cat("2");
        System.out.println(cat1.getName() + " " + cat2.getName());
        short sh=2;
        returnMessageShort(2);
        new Cat();
    }

    static boolean is() {
        return Integer.valueOf("10") < 11;
    }

    Boolean a = true;

    public static void main() {

    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }
        public Cat(){
            this("Barsick");
            System.out.println(getName());
        }

        public String getName() {
            return name;
        }

    }
    static void returnMessageShort(short x){
        System.out.println("short");
    }
    static void returnMessageShort(int x){
        System.out.println("int");
    }
}
