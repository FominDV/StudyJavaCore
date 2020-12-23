import java.util.Arrays;
import java.util.Base64;

public class BitsTest {
    private final static Base64.Encoder ENCODER = Base64.getEncoder();
    private final static Base64.Decoder DECODER = Base64.getDecoder();
    private final static byte CODE_NUMBER = 77;

    public static void main(String[] args) {
        String msg = "Sonia";
        System.out.println(msg);
        //encoder
        byte[] code = ENCODER.encode(msg.getBytes());
       printByteArray(code);
        for (int i = 0; i < code.length; i++) {
            code[i] ^= CODE_NUMBER;
        }
        printByteArray(code);
        msg = new String(code);

        //decoder
        byte[] code1=msg.getBytes();
        printByteArray(code1);
        for (int i = 0; i < code1.length; i++) {
            code1[i] ^= CODE_NUMBER;
        }
        printByteArray(code1);
        code1=DECODER.decode(code1);
        System.out.println(new String(code1));
    }

    static void printByteArray(byte[] array) {
        System.out.println(Arrays.toString(array));
    }
}
