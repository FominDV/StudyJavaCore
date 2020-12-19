interface MyInterface {
    void execute();

    default void print() {
        System.out.println("FOO");
    }
}

public class MyClass {
    public void print() {
        System.out.println("Bar");
    }
public void go(){
        MyInterface mi=()-> print();
        mi.execute();
        mi.print();
}

    public static void main(String[] args) {
        new MyClass().go();
    }
}
