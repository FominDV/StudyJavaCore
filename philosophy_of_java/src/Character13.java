import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Character13 {
    public static void main(String[] args) {
        String str = "12 23 14 5 52";
        System.out.println(str.replaceAll("1", "ONE"));
        System.out.println(str.replaceAll("2(\\d|\\W)+", "0"));
        System.out.printf("dsd dssd\txzx\nsdddddddrsx\n");
        System.out.println("hellow".matches("[^acd]*w"));
        System.out.println("sos".matches("[fds].."));
        Matcher matcher = Pattern.compile("\\w+").matcher("a s d f");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        Matcher matcher1 = Pattern.compile("^a").matcher("abcabc");

        while (matcher1.find()) {
            System.out.println(matcher1.group());
            System.out.println(matcher1.groupCount());
            System.out.println( matcher1.lookingAt());

        }
    }
}
