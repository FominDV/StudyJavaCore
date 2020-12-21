import java.util.*;

public class PriorityQueueTest {
    public static void main(String[] args) {
        for(Map.Entry element: System.getenv().entrySet()){
            System.out.println(element.getKey()+" : "+element.getValue());
        }
        String homePath=System.getenv("OS");

        PriorityQueue<Element> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        List<Element> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) list.add(new Element());
        priorityQueue.addAll(list);
        System.out.println(list);
        System.out.println(priorityQueue);
Map<Integer,Element> map=new HashMap<>();
for(int i=0;i<10;i++) map.put(i,priorityQueue.remove());
        System.out.println(map.values());
        System.out.println(priorityQueue);
        list.addAll(map.values());
        System.out.println(list);
        System.out.println(map.values().getClass());
        Iterator<Integer> iterator=map.keySet().iterator();
        System.out.println(homePath);
        Map<Element,Integer> map1=new TreeMap<>();
        for(int i=0;i<list.size();i++) map1.put(list.get(i),list.get(i).value);
        for(Element m: map1.keySet()) System.out.println(m);
        List<? super Element> list1=new ArrayList<>(list);
        list1.add(new Element());
        Object ee= list1.get(0);
        Element eee=(Element)ee;
        System.out.println(list1);
        for(Object e: list1) System.out.println(e);
        System.out.println(list1.size());
        System.out.println(list1.get(0).getClass().getSimpleName());
    }
}

class Element implements Comparable {
    static int counter = 10;
    int value;

    Element() {
        counter--;
        value = counter;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Element && value == ((Element) o).value) return true;
        else return false;
    }

    @Override
    public int compareTo(Object o) {
        return value - ((Element) o).value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
    @Override
    public int hashCode(){
        return value;
    }
}
