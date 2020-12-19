package FactoryMethod;

import java.util.Random;

public class PlayingDice {
   static void PlayGames(PlayFactory factory){
       factory.getPlay().toss();
    }
    public static void main(String[] args) {
       PlayGames(Dice.factory);
       PlayGames(Coin.factory);
    }
}

interface Play {
    void toss();
}

interface PlayFactory {
    Play getPlay();
}

class Dice implements Play {
    @Override
    public void toss() {
        System.out.println("Dice: "+(new Random().nextInt(5) + 1));
    }
    static PlayFactory factory=new PlayFactory(){
        @Override
      public Play  getPlay(){
            return new Dice();
        }
    };
}

class Coin implements Play {
    @Override
    public void toss() {
        System.out.println("Coin: "+(new Random().nextInt(2) + 1));
    }
    static PlayFactory factory=new PlayFactory(){
        @Override
        public Play getPlay(){
            return new Coin();
        }
    };
}


