package ru.fomin.springcourse;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private String name;
    private int volume;
    private Music music;
    private List<Music> listMusic=new ArrayList<>();

    public void setListMusic(List<Music> listMusic) {
        this.listMusic = listMusic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    //IoC
    public MusicPlayer(Music music) {
        this.music = music;
    }

    public MusicPlayer() {
    }
    public void setMusic(Music music) {
        this.music = music;
    }
    public void playMusic() {
        System.out.println("Playing " + music.getSong());
    }
    public void playMusicList(){
        listMusic.forEach(music-> System.out.println(music.getSong()));
    }
}
