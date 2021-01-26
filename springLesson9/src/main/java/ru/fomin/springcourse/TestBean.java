package ru.fomin.springcourse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class TestBean {

    private String name;

    public TestBean(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void doInit(){
        System.out.println("Inint");
    }
}
