package ru.test.fomin.testing;

import java.util.Random;
import java.util.Scanner;

public class TestForHomework {
    public static void main(String[] args) {
        int game_level = 9;
        int i = 3;
        int repeat = 1;
        int entered_value = -1;

        //основной цикл игры
        while (repeat == 1) {
            //загадываем число
            int magic_value = randomizer(game_level);

            //уходим в цикл в 3 попытки на угадайку
            do {
                System.out.println("");
                System.out.println("Количество оставшихся попыток: " + i);
                System.out.print("Введите число в диапозоне от 0 до " + game_level + ":");
                entered_value = userInput();
                // System.out.print("Вы ввели:" + entered_value);

                if (entered_value >= 0 && entered_value <= game_level) {

                    if (magic_value > entered_value && entered_value != -255) {
                        System.out.println("Вы ввели:" + entered_value + ",но загаданное число больше, попробуйте ещё раз:");
                        i--;
                    } else if (magic_value < entered_value && entered_value != -255) {
                        System.out.println("Вы ввели:" + entered_value + ",но загаданное число меньше, попробуйте ещё раз:");
                        i--;
                    } else {
                        System.out.println("Вы ввели:" + entered_value + " и вы угадали!");
                        i = 0;
                    }
                } else {
                    System.out.println("Вы ввели число вне диапозона: от 0 до " + game_level + " или вовсе не число, попробуйте ещё раз");
                    i--;
                }
            } while (i > 0);
            System.out.println("");
            System.out.println("Повторить игру еще раз? 1 – да / 0  – нет");
            repeat = userInput();
            if (repeat == 1) {
                i = 3;
            } else {
                System.out.println("Ну и ладно");
            }
        }
    }

    //Метод генерирующий число в зависимости от уровня
    public static int randomizer(int game_level) {
        Random rand = new Random();
        int x = rand.nextInt(game_level);
        System.out.println("Мы загадали для вас " + x + " только никому не говорите!");
        return x;
    }

    //Метод ввода переменной и обработки не цифровых значений
    public static int userInput() {
        int digits = -255;
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            digits = sc.nextInt();

        }
        

        return digits;
    }
}
