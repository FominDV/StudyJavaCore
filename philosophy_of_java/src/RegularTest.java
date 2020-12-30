import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularTest {
    public static void main(String[] args) {
        String test="Ivanushka3?";
        System.out.println(test.matches(".*?[<>\\\\\\/\\*\\?\\|\"\\:].*?"));
        StringBuffer s=new StringBuffer();
        Pattern pattern=Pattern.compile("l");

        String s1="hello 12345ffff";
        Matcher matcher=pattern.matcher(s1);
     //  s1= s1.replaceAll(".(1|4)","W");
    //   System.out.println(s1);

        matcher.find();
        matcher.appendReplacement(s,"w");
        matcher.find();
//        matcher.appendReplacement(s,matcher.group());
//        matcher.find();
        matcher.appendTail(s);
        System.out.println(s);
        ////////////////////////////////////////////////////////////////////
        Scanner read=new Scanner(System.in);
        read.useDelimiter("\\d+|\\s");
        List<String> list=new ArrayList<>();
        String r="";
      while (read.hasNext("\\w+")){
           r=read.next();
        list.add(r); }
        System.out.println(list);
    }
}
