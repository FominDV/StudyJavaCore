public class Test3 {
    public static void main(String[] args) {
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


    }
}
