package ru.fomin.springcourse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.fomin.springcourse")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
    @Bean
    public ClassicalMusic someClassicMusic(){
        return new ClassicalMusic();
    }
    @Bean
   public MusicPlayer musicPlayer(){
        return new MusicPlayer(someClassicMusic());
    }
    @Bean
    public Computer computer(){
        return new Computer(musicPlayer());
    }
}
