package ru.fomin.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MusicPlayer {
    private String name;
    @Value("${musicPlayer.volume}")
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

//    public void setVolume(int volume) {
//        this.volume = volume;
//    }

    //IoC
    @Autowired
    public MusicPlayer( @Qualifier("someClassicMusic")Music music) {
        this.music = music;
    }

    public MusicPlayer() {
    }

    public void setMusic(Music music) {
        this.music = music;
    }
    public String playMusic() {
       // System.out.println("Playing " + music.getSong());
        return "Playing " + music.getSong();
    }
    public void playMusicList(){
        listMusic.forEach(music-> System.out.println(music.getSong()));
    }
}
