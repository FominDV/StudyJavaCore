import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        class A1 {
            public String toString() {
                return this.getClass().getSimpleName();
            }
        }
        class B1 extends A1 {
        }
        class B11 extends A1 {
        }
        class C2 extends B1 {
        }
        class C22 extends B1 {
        }
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(list);
        Collections.addAll(list, 6);
        System.out.println(list);
        Integer[] arr = {7, 8, 9};
        Collections.addAll(list, arr);
        System.out.println(list);
        List<B1> list1 = Arrays.asList(new C22(), new C2());
        System.out.println(list1);
        List<Integer> list2=new ArrayList<>(Arrays.asList(2,3,-1));
        list.removeAll(list2);
        System.out.println(list);
        Iterator<Integer> iterator=list.iterator();
        while (iterator.hasNext()){
            Integer element=iterator.next();
            if(element>4) iterator.remove(); else System.out.println(element);
        }
        System.out.println(list);
        List<? extends Number> list3=new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(list3);
        System.out.println(list3.get(1));

    }

}
