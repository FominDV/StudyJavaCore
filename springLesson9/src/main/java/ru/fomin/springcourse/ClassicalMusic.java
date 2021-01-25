package ru.fomin.springcourse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("someClassicMusic")
@Scope("prototype")
public class ClassicalMusic implements Music, Music2 {
    private String[] songs = {"Simphony", "Bethowen", "Mothart"};

    @Override
    public String getSong() {
        return "Simphony";
    }


    private void privateInit() {
        System.out.println("privateInit");

//        try {
//            System.out.println(getClass().getDeclaredMethod("privateInit", null));
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
    }


    public void doDestroy1() {
        System.out.println("destroy-method of " + getClass().getSimpleName());
    }

    @Override
    public String[] getSongs() {
        return songs;
    }
}
