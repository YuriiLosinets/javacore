package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(reader.readLine()));
        String line;
        while ((line = br.readLine()) != null)
        {
            list.add(line);
        }
        for (String s : list)
        {
            if (s.substring(0,s.indexOf(' ')).equals(args[0]))
                System.out.println(s);
        }
        reader.close();
        br.close();
    }
}
