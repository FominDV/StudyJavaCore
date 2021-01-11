public class TestReturn {
    public static void main(String[] args) {
        String s = "";
        System.out.println(getEditedStringTemplateValue(s));
    }

    private static String getEditedStringTemplateValue(String inputComponentHtml) {
        StringBuffer stringBuffer = new StringBuffer(inputComponentHtml);
        char charOfStringBuffer;
        int lengthOfStringBuffer = stringBuffer.length();
        for (int i = 0; i < lengthOfStringBuffer; i++) {
            charOfStringBuffer = stringBuffer.charAt(i);
            if (charOfStringBuffer == '\"') stringBuffer.setCharAt(i, '\'');
            else if (charOfStringBuffer == '\n') {
                stringBuffer.deleteCharAt(i);
                i--;
                lengthOfStringBuffer--;
            } else if (i != stringBuffer.length() - 1 && charOfStringBuffer == '[' && stringBuffer.charAt(i + 1) == ']') {
                stringBuffer.setCharAt(i, '[');
                stringBuffer.setCharAt(i + 1, ']');
                i++;
            }
        }
        return stringBuffer.toString();
    }
//return inputComponentHtml.replaceAll("\"", "'").replaceAll("\n", "").replace("[]", "{}");
}

