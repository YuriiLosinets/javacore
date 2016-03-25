package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner scanner = new Scanner(new File(reader.readLine()));
        while (scanner.hasNextInt())
        {
            list.add(scanner.nextInt());
        }
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i)%2 != 0)
            {
                list.remove(i);
                i--;
            }

        }
        Collections.sort(list);
        for (int i : list)
        {
            System.out.println(i);
        }
        scanner.close();
        reader.close();
    }
}
