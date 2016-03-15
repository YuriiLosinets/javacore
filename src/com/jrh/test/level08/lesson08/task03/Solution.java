package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 10; i++)
        {
            map.put("LastName" + i, "FirstName" + i);
        }
        return (HashMap<String, String>) map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int countTheSameFirstName = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            //получение «пары» элементов
            Map.Entry<String, String> pair = iterator.next();
            String value = pair.getValue();
            if (value.equals(name))
                countTheSameFirstName += 1;
        }
        return countTheSameFirstName;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        int countTheSameLastName = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();
            if (key.equals(familiya))
                countTheSameLastName += 1;
        }
        return countTheSameLastName;
    }
}
