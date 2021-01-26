package ru.fomin.springcourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
      // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
      //  Music music=context.getBean("someClassicMusic",Music.class);
      //  MusicPlayer musicPlayer=context.getBean("musicPlayer",MusicPlayer.class);
        Computer computer=context.getBean("computer",Computer.class);
        System.out.println(computer);
      //  musicPlayer=new MusicPlayer(context.getBean("rockMusic",Music.class));
      //  musicPlayer.playMusic();
      //  MusicPlayer2 musicPlayer2=context.getBean("musicPlayer2",MusicPlayer2.class);
       // musicPlayer2.playMusic(MusicType.ROCK);
        context.close();
    }

}
