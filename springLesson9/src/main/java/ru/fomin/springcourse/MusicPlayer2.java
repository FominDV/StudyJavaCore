package ru.fomin.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer2 {
    private Music2 music1, music2;

    @Autowired
    public MusicPlayer2(@Qualifier("someClassicMusic") Music2 music1, @Qualifier("rockMusic") Music2 music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public void playMusic(MusicType musicType) {

        switch (musicType) {
            case ROCK:
                playSong(music2);
                break;
            case CLASSICAL:
                playSong(music1);
                break;
            default:
                System.out.println("Unknown music type");
        }
    }

    private void playSong(Music2 music) {
        System.out.println("Playing " + music.getSongs()[new Random().nextInt(3)]);
    }
}
