package ru.fomin.springcourse;


import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music,Music2 {
    private String[] songs={"AC/DC","King and Joker","Aria"};
    private RockMusic() {
    }

    public static RockMusic getRockMusic() {
        System.out.println("Factory method was used for " + RockMusic.class.getSimpleName());
        return new RockMusic();
    }



    public void init(){
    System.out.println("init");
}
    @Override
    public String getSong() {
        return "AC/DC";
    }

    @Override
    public String[] getSongs() {
        return songs;
    }
}
