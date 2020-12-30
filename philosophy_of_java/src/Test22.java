import java.util.ArrayList;
import java.util.List;

public class Test22 {
    public static void main(String[] args) {
        String a=new String("a");
        String b1="a";
        String b="a";
        System.out.println(a.intern()==b);
        System.out.println(b1==b);

method();
    }
    static void method(){
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        for(String s:list) System.out.println(s);
    }
}
