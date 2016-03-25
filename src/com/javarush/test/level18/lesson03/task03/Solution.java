package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        while (inputStream.available() > 0)
        {
            int i = inputStream.read();
            if (map.containsKey(i))
            {
                map.put(i, map.get(i) + 1);
            }
            else
            {
                map.put(i, 1);
            }
        }
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        result.put(1,1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            for (Map.Entry<Integer, Integer> entry1 : result.entrySet())
            {
                if (entry.getValue() > entry1.getValue())
                {
                    result.remove(entry1.getKey());
                    result.put(entry.getKey(),entry.getValue());
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry2 : result.entrySet())
        {
            System.out.print(entry2.getKey() + " ");
        }
        inputStream.close();
        reader.close();
    }
}
