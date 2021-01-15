import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestReturn {
    public static void main(String[] args) throws IOException {
        String s = "";
        BufferedReader reader = Files.newBufferedReader(Path.of("C:\\Geek Brains\\Java\\philosophy_of_java\\src\\test3.txt"));
        long start;
        while (reader.ready()) s += reader.readLine()+"\n";
        reader.close();
       start = System.currentTimeMillis();
      getEditedStringTemplateValue2(s);
      System.out.println("2: " + (System.currentTimeMillis() - start));
       start = System.currentTimeMillis();
       getEditedStringTemplateValue(s);
       System.out.println("1: " + (System.currentTimeMillis() - start));
      start = System.currentTimeMillis();
     s.replaceAll("\"", "'").replaceAll("\n", "").replace("[]", "{}");
       System.out.println("replays: " + (System.currentTimeMillis() - start));
       start = System.currentTimeMillis();
        getEditedStringTemplateValue3(s);
        System.out.println("3: " + (System.currentTimeMillis() - start));
       start = System.currentTimeMillis();
       getEditedStringTemplateValue4(s);
       getEditedStringTemplateValue4("fsfsfs\nsds[[[]]sds\"ccs[");
//        // System.out.println(getEditedStringTemplateValue4("fsfsfs\nsds[[[]]sds\"ccs["));
       System.out.println("4: " + (System.currentTimeMillis() - start));
    //   System.out.println("argument: " + "dfd\"\'[]\n][[][]{}\"\'\n[]");
        String a=getEditedStringTemplateValue3("\n\n\n");
       System.out.println("result: " + getEditedStringTemplateValue3("\n\n\n"));

        start = System.currentTimeMillis();
        System.out.println(getEditedStringTemplateValue3(s).equals(s.replaceAll("\"", "'").replaceAll("\n", "").replace("[]", "{}")));
    //    getEditedStringTemplateValue5(s);
        System.out.println("5: " + (System.currentTimeMillis() - start));
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
        char currentChar;
        int countOfNull = 0;
        int length = inputComponentHtml.length();
        char[] chars = new char[length];
        for (int i = 0, j = 0; i < length; i++, j++) {
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
        return new String(chars, 0, chars.length - countOfNull);
    }

    private static String getEditedStringTemplateValue4(String inputComponentHtml) {
        Matcher matcher = Pattern.compile("(\"|\n|\\[])").matcher(inputComponentHtml);
        int currentIndexOfArgument = 0, currentIndexOfResult = 0, matcherStart, lengthForArrayCopy;
        char[] charsOfArgument = inputComponentHtml.toCharArray();
        char[] charsOfResult = new char[inputComponentHtml.length()];
        while (matcher.find(currentIndexOfArgument)) {
            matcherStart = matcher.start();
            lengthForArrayCopy = matcherStart - currentIndexOfArgument;
            System.arraycopy(charsOfArgument, currentIndexOfArgument, charsOfResult, currentIndexOfResult, lengthForArrayCopy);
            currentIndexOfResult += lengthForArrayCopy;
            switch (charsOfArgument[matcherStart]) {
                case '\"':
                    charsOfResult[currentIndexOfResult++] = '\'';
                    break;
                case '[':
                    charsOfResult[currentIndexOfResult++] = '{';
                    charsOfResult[currentIndexOfResult++] = '}';
                    matcherStart++;
                    break;
            }
            currentIndexOfArgument = ++matcherStart;
        }
        System.arraycopy(charsOfArgument, currentIndexOfArgument, charsOfResult, currentIndexOfResult, charsOfArgument.length - currentIndexOfArgument);
        return new String(charsOfResult);
    }

    private static String getEditedStringTemplateValue5(String inputComponentHtml) {
        int length = inputComponentHtml.length(), countOfSymbolsForPart = 20000;
        int contOfThreads = length <= countOfSymbolsForPart ? 1 : length / countOfSymbolsForPart;
        ConverterForPartOfInputComponentHtmlThread[] converterThreadArray = new ConverterForPartOfInputComponentHtmlThread[contOfThreads];
        String partOfInputComponentHtml, resultString = "";
        for (int i = 0; i < contOfThreads; i++) {
            partOfInputComponentHtml = contOfThreads != i + 1 ?
                    inputComponentHtml.substring(i * countOfSymbolsForPart, (i + 1) * countOfSymbolsForPart)
                    : inputComponentHtml.substring(i * countOfSymbolsForPart);
            converterThreadArray[i] = new ConverterForPartOfInputComponentHtmlThread(partOfInputComponentHtml);
            converterThreadArray[i].start();
           
        }

        for (ConverterForPartOfInputComponentHtmlThread converterThread : converterThreadArray) {
            try {
                converterThread.join();
                resultString += converterThread.getConvertedPartOfInputComponentHtml();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

    private static class ConverterForPartOfInputComponentHtmlThread extends Thread {
        private String convertedPartOfInputComponentHtml, partOfInputComponentHtml;

        public String getConvertedPartOfInputComponentHtml() {
            return convertedPartOfInputComponentHtml;
        }

        public ConverterForPartOfInputComponentHtmlThread(String partOfInputComponentHtml) {
            this.partOfInputComponentHtml = partOfInputComponentHtml;
        }

        @Override
        public void run() {
            char currentChar;
            int countOfNull = 0;
            int length = partOfInputComponentHtml.length();
            char[] chars = new char[length];
            for (int i = 0, j = 0; i < length; i++, j++) {
                currentChar = partOfInputComponentHtml.charAt(i);
                switch (currentChar) {
                    case '\"':
                        chars[j] = '\'';
                        break;
                    case '\n':
                        j--;
                        countOfNull++;
                        break;
                    case '[':
                        if (i != length - 1 && partOfInputComponentHtml.charAt(i + 1) == ']') {
                            chars[j] = '{';
                            chars[++j] = '}';
                            i++;
                            break;
                        }
                    default:
                        chars[j] = currentChar;
                }
            }
            convertedPartOfInputComponentHtml = new String(chars, 0, chars.length - countOfNull);
        }
    }
}

