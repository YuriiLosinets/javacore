package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution
{
    public static List<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        while (inputStream.available() > 0)
        {
            int i = inputStream.read();
            if (!list.contains(i))
            {
                list.add(i);
            }
        }
        Collections.sort(list);
        for (int i : list)
        {
            System.out.print(i + " ");
        }
        reader.close();
        inputStream.close();
    }
}
