package com.javarush.test.level21.lesson16.big01;

import java.util.*;

/**
 * Created by CMI-USER on 12/14/2015.
 */
public class Hippodrome
{
    private static ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();

        horses.add(new Horse("Spirit",3,0));
        horses.add(new Horse("Yuliy",3,0));
        horses.add(new Horse("Bohatur",3,0));

        game.run();
        game.printWinner();
    }

    public Horse getWinner()
    {
        Horse winner = horses.get(0);
        for(Horse horse : horses)
        {
            if(horse.getDistance() > winner.getDistance())
                winner = horse;
        }
        return winner;
    }
    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public void run() throws InterruptedException
    {
        for (int i = 1; i <= 100; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move()
    {
        for (Horse horse: horses)
        {
            horse.move();
        }
    }

    public void print()
    {
        for (Horse horse: horses)
        {
            horse.print();
            System.out.println();
            System.out.println();
        }
    }

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }
}
