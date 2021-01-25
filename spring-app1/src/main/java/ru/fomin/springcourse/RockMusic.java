package ru.fomin.springcourse;

public class RockMusic implements Music {
    private RockMusic() {
    }

    public static RockMusic getRockMusic() {
        System.out.println("Factory method was used for " + RockMusic.class.getSimpleName());
        return new RockMusic();
    }

    @Override
    public String getSong() {
        return "AC/DC";
    }
}
