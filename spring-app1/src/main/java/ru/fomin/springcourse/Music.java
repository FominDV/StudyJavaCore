package ru.fomin.springcourse;

public interface Music {
    String getSong();

    default void doInit() {
        System.out.println("initialization "+this.getClass().getSimpleName());
    }

    default void doDestroy() {
        System.out.println("destruction "+this.getClass().getSimpleName());
    }
}