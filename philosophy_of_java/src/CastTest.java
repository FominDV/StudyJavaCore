import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

public class CastTest {
    public static void main(String[] args) throws IOException {
//        float floatPi = 22/7f;
//        float floatPiCast =  (float) (22f/7);
//        System.out.println("floatPi " + floatPi + " floatCastPi " + floatPiCast);
//
//
//        //double       64-битное знаковое число с плавающей запятой двойной точности
//        double doublePi = (double) 22/7;
//        System.out.println("doublePi " + doublePi);
        //////////////////////////////////////
        char letter;
        DataInputStream in=new DataInputStream(System.in);
        do {
            System.out.println("Inter dot for exit");
            letter = in.readChar();

        } while (letter != '.');
    }
}
