interface MyInterface {
    void execute();

//  default void print() {
//        System.out.println("FOO");
//    }
}

public class MyClass {
    public void print() {
        System.out.println("Bar");
    }
public void go(){
        MyInterface mi=new MyInterface() {
            @Override
            public void execute() {
              print();
            }
        };
        mi.execute();
        
}

    public static void main(String[] args) {
        new MyClass().go();
    }
}
