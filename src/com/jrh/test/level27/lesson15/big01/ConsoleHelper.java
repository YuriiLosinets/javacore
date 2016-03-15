package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CMI-USER on 1/14/2016.
 */
public class ConsoleHelper
{
    private static BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message)
    {
        System.out.println(message);
    }
    public static String readString() throws IOException
    {
        return consolereader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        List<Dish> dishes = new ArrayList<Dish>();
        writeMessage(Dish.allDishesToString());
        String dish = readString();
        while (!dish.equalsIgnoreCase("exit"))
        {
            try
            {
                dishes.add(Dish.valueOf(dish));
                writeMessage("Please, choose a Dish or EXIT");
            }
            catch (IllegalArgumentException e)
            {
                writeMessage(dish + " is not detected");
            }
            dish = readString();
        }
        return dishes;
    }
}
