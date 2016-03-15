package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n1 = reader.readLine();
        String n2 = reader.readLine();
        String n3 = reader.readLine();
        Integer m1 = Integer.parseInt(n1);
        Integer m2 = Integer.parseInt(n2);
        Integer m3 = Integer.parseInt(n3);
        if ((m1 >= m2 && m1 <= m3)||(m1 >= m3 && m1 <= m2))
            System.out.println(m1);
        else if ((m2 >= m1 && m2 <= m3)||(m2 >= m3 && m2 <= m1))
            System.out.println(m2);
        else
            System.out.println(m3);
    }
}
