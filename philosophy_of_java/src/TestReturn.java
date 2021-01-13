import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestReturn {
    public static void main(String[] args) throws IOException {
        String s = "";
        BufferedReader reader = Files.newBufferedReader(Path.of("C:\\Geek Brains\\Java\\philosophy_of_java\\src\\test2.txt"));
        long start;
        while (reader.ready()) s += reader.readLine();
        reader.close();
        start = System.currentTimeMillis();
          getEditedStringTemplateValue2(s);
        System.out.println("2: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
          getEditedStringTemplateValue(s);
        System.out.println("1: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
          s.replace("\"", "'").replace("\n", "").replace("[]", "{}");
        System.out.println("replays: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
         getEditedStringTemplateValue3(s);
        System.out.println("3: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        getEditedStringTemplateValue4(s);
        //getEditedStringTemplateValue4("fsfsfs\nsds[[[]]sds\"ccs[");
       // System.out.println(getEditedStringTemplateValue4("fsfsfs\nsds[[[]]sds\"ccs["));
        System.out.println("4: " + (System.currentTimeMillis() - start));

    }

    private static String getEditedStringTemplateValue(String inputComponentHtml) {
        StringBuilder stringBuilder = new StringBuilder(inputComponentHtml);
        int lengthOfStringBuffer = stringBuilder.length();
        for (int i = 0; i < lengthOfStringBuffer; i++) {
            switch (stringBuilder.charAt(i)) {
                case '\"':
                    stringBuilder.setCharAt(i, '\'');
                    break;
                case '\n':
                    stringBuilder.deleteCharAt(i);
                    i--;
                    lengthOfStringBuffer--;
                    break;
                case '[':
                    if (i != lengthOfStringBuffer - 1 && stringBuilder.charAt(i + 1) == ']') {
                        stringBuilder.setCharAt(i, '{');
                        stringBuilder.setCharAt(i + 1, '}');
                        i++;
                    }
            }
        }
        return stringBuilder.toString();
    }

    private static String getEditedStringTemplateValue2(String inputComponentHtml) {
        char currentChar;
        int length = inputComponentHtml.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            currentChar = inputComponentHtml.charAt(i);
            switch (currentChar) {
                case '\"':
                    stringBuilder.append('\'');
                    break;
                case '\n':
                    break;
                case '[':
                    if (i != length - 1 && inputComponentHtml.charAt(i + 1) == ']') {
                        stringBuilder.append("{}");
                        i++;
                    } else stringBuilder.append('[');
                    break;
                default:
                    stringBuilder.append(currentChar);
            }
        }
        return stringBuilder.toString();
    }

    private static String getEditedStringTemplateValue3(String inputComponentHtml) {
        int length = inputComponentHtml.length();
        char[] chars = new char[length];
        char currentChar;
        int countOfNull = 0;
        for (int i = 0, j = 0; i < chars.length; i++, j++) {
            currentChar = inputComponentHtml.charAt(i);
            switch (currentChar) {
                case '\"':
                    chars[j] = '\'';
                    break;
                case '\n':
                    j--;
                    countOfNull++;
                    break;
                case '[':
                    if (i != length - 1 && inputComponentHtml.charAt(i + 1) == ']') {
                        chars[j] = '{';
                        chars[++j] = '}';
                        i++;
                        break;
                    }
                default:
                    chars[j] = currentChar;
            }
        }
        return new String(chars,0,chars.length-countOfNull);
    }

    private static String getEditedStringTemplateValue4(String inputComponentHtml) {


    return     inputComponentHtml.chars().filter(value -> value != '\n')
                .map(i -> {
                    if (i == '\"') return '\'';
                    return i;
                }).collect(
                    StringWriter::new,
                    StringWriter::write,
                    (swl, swr) -> swl.write(swr.toString())).toString();
                //.forEach(i -> System.out.print((char) i));


    }

}

