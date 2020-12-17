import static java.lang.Math.*;

public class test4 {

    public static void main(String[] args) {
        printArray(11, "12", "ga");
        for (Money money : Money.values()) money.printCost();
        System.out.println(pow(2, 10) + cos(PI));
     B b=   new B();
     b.f();
    }

    static <T> void printArray(T... array) {
        for (T element : array) System.out.println(element);
    }


}

class A {
static void f() {
        System.out.println("A");
    }
}
    class B extends A {

     static void f() {
            A.f();
            System.out.println("B");
        }
    }
