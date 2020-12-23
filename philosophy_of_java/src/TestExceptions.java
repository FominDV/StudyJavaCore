import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class TestExceptions {
    public static void main(String[] args) {

        Scanner read=new Scanner(System.in);

        try {
            checkedExceptionMethod();
        }catch (RuntimeException e){
            System.out.println(e);
            System.out.println("--------------------------");
           try {
               throw e.getCause();
           }catch (IOException e1){
               System.out.println(e1);
           } catch (Throwable throwable) {
               throwable.printStackTrace();
           }
        }

        class A {
            void f() throws Exception {
            }
        }
        class B extends A {
            void g() {
            }
        }
        try {
            throwException();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("wwwwwwwwwwwwwwwwwwwwwwwww");
            System.out.println(e.getLocalizedMessage());
        }
        System.out.println(getRandomNumber());
        B b = new B();
        try {
            b.f();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void throwException() throws NullPointerException {
        throw new NullPointerException("fromMethod");
    }

    static int getRandomNumber() {
        try {
            int a = new Random().nextInt();
            System.out.println("a=" + a);
            return a;
        } finally {
            return 3;
        }
    }

    static void checkedExceptionMethod() {
        try (FileWriter out = new FileWriter("log.txt", true)){

            System.out.println("checked");
            throw new IOException();
        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}
