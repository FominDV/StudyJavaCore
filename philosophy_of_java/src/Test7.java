import java.util.ArrayList;
import java.util.LinkedList;

public class Test7 extends WithInner.Inner {
    public Test7(WithInner wi){wi.super();}

    public static void main(String[] args) {
        ArrayList<? super Number> list=new ArrayList<>();
        list.add(new Integer(10));
        list.add(2.5f);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        Test7 tet7=new Test7(new WithInner());
        tet7.print();
    }
}
class WithInner{
    class Inner{void print(){
        System.out.println("inner");
    }}
}
