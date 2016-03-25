package com.javarush.test.level30.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by CMI-USER on 1/18/2016.
 */
public class ConsoleHelper
{
    private static BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message)
    {
        System.out.println(message);
    }
    public static String readString()
    {
        String message;

        while (true)
        {

            try
            {
                message = consolereader.readLine();
                break;

            }
            catch (IOException e)
            {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return message;
    }

    public static int readInt()
    {
        int i;

        while (true)
        {

            try
            {
                i = Integer.parseInt(readString());
                break;

            }
            catch (NumberFormatException e)
            {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return i;
    }
}
