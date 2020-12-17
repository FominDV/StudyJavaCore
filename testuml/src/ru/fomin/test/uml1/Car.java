package ru.fomin.test.uml1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;

public class Car implements Inter, Runnable{

void run(Engine engine){
    engine.run();
}


    @Override
    public void drive() {
        System.out.println("ss");
    }

    @Override
    public void run() {

    }
}
