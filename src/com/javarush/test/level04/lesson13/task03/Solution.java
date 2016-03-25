package com.javarush.test.level04.lesson13.task03;
import java.io.*;

/* Рисуем треугольник
Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.
Пример:
8
88
888
...
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        StringBuilder stars = new StringBuilder();

        /*for(int i = 1; i <= 10; i++)
        {
            stars.append("8");
            System.out.println(stars);
        }*/
        for (int x = 1; x <= 10; x++)
        {
            for (int y = 1; y <= x; y++)
            {
                System.out.print("8");
            }
            System.out.println("");
        }
    }
}
