import sun.nio.cs.UTF_32;
import sun.text.normalizer.UTF16;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StreamTest {
    public static void main(String[] args) {
        String java = "привет";
        char j = 'j';
        byte[] arr = java.getBytes();
        System.out.println(new String(arr));
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("stream_test.txt"))) {
            System.out.println(arr.length);
            out.writeBytes(new String(arr));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("read:");
        try (InputStream in = new FileInputStream(new File("stream_test.txt"))) {
            int counterForWhile = 0;
            byte[] arr1 = new byte[10];
            in.read(arr1);
            for (int i = 0; i < arr1.length; i++) {
                System.out.println(counterForWhile + ": " + arr1[i]);
            }
            System.out.println(new String(arr1));
        } catch (IOException e) {
            e.printStackTrace();
        }

        class Array implements Serializable {
            private transient int[] intArr = new int[10];

            Array() {
                for (int j = 0; j < intArr.length; j++)
                    intArr[j] = j;
            }

            int[] getIntArr() {
                return intArr;
            }
        }
        byte[] objectArr = null;
        Array a = new Array();
        try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream("stream_object.txt"));
             ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
             ObjectOutputStream arrOut = new ObjectOutputStream(bytesOut);
             ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream("stream_object.txt"))) {
            objectOut.writeObject(a);
            try {
                Array b = (Array) objectInput.readObject();
                System.out.println(Arrays.toString(b.getIntArr()));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            arrOut.writeObject(a);
            objectArr = bytesOut.toByteArray();
            System.out.println(Arrays.toString(objectArr));
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (SequenceInputStream seqIn = new SequenceInputStream(new FileInputStream("stream_object.txt"), new FileInputStream("stream_test.txt"));
             FileOutputStream fileOut = new FileOutputStream("sequence_file.txt")) {
            int x;
            while ((x = seqIn.read()) != -1) {
                fileOut.write(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

