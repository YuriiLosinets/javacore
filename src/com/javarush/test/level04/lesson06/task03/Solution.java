package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

import static java.lang.System.out;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a1 = reader.readLine();
        String b1 = reader.readLine();
        String c1 = reader.readLine();
        Integer a = Integer.parseInt(a1);
        Integer b = Integer.parseInt(b1);
        Integer c = Integer.parseInt(c1);
        if (a > b && a > c)
        {
            if (b > c)
                out.println(a + " " +  b + " " + c);
            else
                out.println(a + " " +  c + " " +  b);
        }
        else if (b > a && b > c)
        {
            if (a > c)
                out.println(b + " " +  a + " " +  c);
            else
                out.println(b + " " +  c + " " +  a);
        }
        else
        {
            if (a > b)
                out.println(c + " " +  a + " " +  b);
            else
                out.println(c + " " + b + " " +  a);
        }
    }
}
