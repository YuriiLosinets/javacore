package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая короткая строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();
        String s = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++)
        {
            list.add(reader.readLine());
        }

        for (int i = 0; i < list.size(); i++)
        {
            s += list.get(i);
        }

        result.add(s);

        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).length() < result.get(0).length())
            {
                result.clear();
                result.add(list.get(i));
            }
            else if (list.get(i).length() == result.get(0).length())
            {
                result.add(list.get(i));
            }
        }
        for (int i = 0; i < result.size(); i++)
        {
            System.out.println(result.get(i));
        }
    }
}
