package ru.fomin.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    private int id;
    private MusicPlayer musicPlayer;

    @Autowired
    public Computer(MusicPlayer musicPlayer) {
        id = 1;
        this.musicPlayer = musicPlayer;
    }

    @Override
    public String toString() {
        return String.format("Computer %-2d:\nvolume=%d\nmusic: %s", id,musicPlayer.getVolume(), musicPlayer.playMusic());
    }
}
