package ru.fomin.test.uml1;

import java.util.concurrent.ConcurrentMap;

public class Main {
    public static void main(String[] args) {
Car miniCar=new MiniCar();

Thread t=new Thread(new Runnable() {
    @Override
    public void run() {

        System.out.println(1);
    }
});




    }
}
