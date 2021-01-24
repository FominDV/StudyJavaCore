package ru.fomin.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //DI
        MusicPlayer musicPlayer=context.getBean("musicPlayer",MusicPlayer.class);
        //DI setter
        MusicPlayer musicPlayer0=context.getBean("musicPlayer0",MusicPlayer.class);
        //without DI
        MusicPlayer musicPlayer1=new MusicPlayer(context.getBean("metalBean",Music.class));
        //From file properties DI for setter
        MusicPlayer musicPlayer2=context.getBean("musicPlayerFile",MusicPlayer.class);
        musicPlayer.playMusic();
        musicPlayer0.playMusic();
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer0.getName()+"\n"+musicPlayer0.getVolume());
        musicPlayer1.playMusic();
        System.out.println(musicPlayer2.getClass().getSimpleName()+"->");
        System.out.println("name="+musicPlayer2.getName()+"\nvolume="+musicPlayer2.getVolume());
        System.out.println("------------------------");
        musicPlayer0.playMusic();
        musicPlayer0.playMusicList();

        MusicPlayer musicPlayer01=context.getBean("musicPlayer0",MusicPlayer.class);
        System.out.println("musicPlayer0==musicPlayer01: "+(musicPlayer01==musicPlayer0));
        musicPlayer01.setVolume(10000);
        System.out.println(musicPlayer0.getVolume());
        context.close();
    }
}
