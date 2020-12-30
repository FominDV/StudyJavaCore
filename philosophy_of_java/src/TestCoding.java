import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TestCoding {
    static DataOutputStream out;
   static DataInputStream in;
   private static final byte KEY=77;
    public static void main(String[] args) throws IOException {
        in=new DataInputStream(new FileInputStream("test_coding.txt"));
        out=new DataOutputStream(new FileOutputStream("test_coding.txt"));
        String msg="Шhijk";
        System.out.println(msg);
        msg=coding(msg);
        System.out.println(msg);
        out.writeUTF(msg);
       msg= in.readUTF();
       msg=coding(msg);
        System.out.println(msg);
    }
    static private String coding(String message){
        byte[] bytes=message.getBytes(StandardCharsets.UTF_16);
        System.out.println("l:"+bytes.length);
        int l=bytes.length-4;
        for(int i=2;i<bytes.length;i++) bytes[i]^=KEY;
        return new String(bytes, StandardCharsets.UTF_16);
    }

}
