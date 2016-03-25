package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
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
        List<String> list = new ArrayList<String>();
        for (Map.Entry<String, Double> entry : map.entrySet()) list.add(entry.getKey());
        Collections.sort(list);
        for (String d : list)
        {
            for (Map.Entry<String, Double> entry : map.entrySet())
            {
                if (d == entry.getKey())
                    System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
        reader.close();
    }
}
