package com.javarush.test.level06.lesson08.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Класс ConsoleReader
Сделать класс ConsoleReader, у которого будут 4 статических метода:
String readString() – читает с клавиатуры строку
int readInt() – читает с клавиатуры число
double readDouble() – читает с клавиатуры дробное число
boolean readBoolean() – читает с клавиатуры строку "true" или "false" и возвращает соответствующую логическую переменную true или false
Внимание: создавайте переменную для чтения данных с консоли (BufferedReader или Scanner) внутри каждого метода
*/

public class ConsoleReader
{
    public static String readString() throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        return line;
    }

    public static int readInt() throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer number = Integer.parseInt(reader.readLine());
        return number;
    }

    public static double readDouble() throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double number1 = Double.parseDouble(reader.readLine());
        return number1;
    }

    public static boolean readBoolean() throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean result = Boolean.parseBoolean(reader.readLine());
        return result;
    }
}
