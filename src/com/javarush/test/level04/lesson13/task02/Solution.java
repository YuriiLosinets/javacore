package com.javarush.test.level04.lesson13.task02;

import java.io.*;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String m1 = reader.readLine();
        String n1 = reader.readLine();
        Integer m = Integer.parseInt(m1);
        Integer n = Integer.parseInt(n1);
        String s = "8";
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                System.out.print(s);
            }
            System.out.println();
        }
    }
}
