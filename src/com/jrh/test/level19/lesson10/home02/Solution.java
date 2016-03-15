package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Map<String, Double> map= new HashMap<String, Double>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready())
        {
            String line = reader.readLine();
            String[] array = line.split(" ");
            if (!map.containsKey(array[0])) map.put(array[0], Double.parseDouble(array[1]));
            else map.put(array[0], map.get(array[0]) + Double.parseDouble(array[1]));
        }
        List<Double> list = new ArrayList<Double>();
        for (Map.Entry<String, Double> entry : map.entrySet()) list.add(entry.getValue());
        Collections.sort(list);
        for (Map.Entry<String, Double> entry : map.entrySet())
        {
            if (list.get(list.size()-1) == entry.getValue())
                System.out.println(entry.getKey());
        }

        reader.close();
    }
}
