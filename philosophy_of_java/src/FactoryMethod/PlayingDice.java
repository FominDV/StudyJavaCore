package FactoryMethod;

import java.util.Random;

public class PlayingDice {
   static void PlayGames(PlayFactory factory){
        Play play=factory.getPlay();
        play.toss();
    }
    public static void main(String[] args) {
       PlayGames(new DiceFactory());
       PlayGames(new CoinFactory());
    }
}

interface Play {
    void toss();
}

interface PlayFactory {
    Play getPlay();
}

class dice implements Play {
    @Override
    public void toss() {
        System.out.println("Dice: "+(new Random().nextInt(5) + 1));
    }
}

class coin implements Play {
    @Override
    public void toss() {
        System.out.println("Coin: "+(new Random().nextInt(2) + 1));
    }
}
class DiceFactory implements PlayFactory{
    @Override
    public Play getPlay() {
        return new dice();
    }
}
class CoinFactory implements PlayFactory{
    @Override
    public Play getPlay() {
        return new coin();
    }
}

