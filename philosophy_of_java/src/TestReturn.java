import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class TestReturn {
    public static void main(String[] args) throws IOException {
        String s ="";
        BufferedReader reader= Files.newBufferedReader(Path.of("C:\\Geek Brains\\Java\\philosophy_of_java\\src\\test.txt"));
        long start;
        while (reader.ready())s+=reader.readLine();
        start=System.currentTimeMillis();
        getEditedStringTemplateValue2(s);
        System.out.println(System.currentTimeMillis()-start);
        start=System.currentTimeMillis();
       getEditedStringTemplateValue(s);
        System.out.println(System.currentTimeMillis()-start);
        start=System.currentTimeMillis();
        s.replaceAll("\"", "'").replaceAll("\n", "").replace("[]", "{}");
        System.out.println(System.currentTimeMillis()-start);

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

}

