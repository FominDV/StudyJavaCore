public class TestReturn {
    public static void main(String[] args) {
        String s = "";
        System.out.println(getEditedStringTemplateValue(s));
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
//return inputComponentHtml.replaceAll("\"", "'").replaceAll("\n", "").replace("[]", "{}");
}

