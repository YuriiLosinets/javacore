package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        File file1 = new File(args[0]);
        File file2 = new File(args[1]);
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        FileWriter writer = new FileWriter(file2);
        String line;
        List<String> list = new ArrayList<String>();
        List<String> result = new ArrayList<String>();
        while ((line = reader. readLine()) != null)
            list.add(line);
        reader.close();
        for (int j = 0; j<list.size(); j++)
        {
            String[] arr = list.get(j).split(" ");
            for (int i = 0; i < arr.length; i++)
            {
                if (arr[i].length()>6)
                    result.add(arr[i]);
            }
        }
        for (int k = 0; k < result.size(); k++)
        {
            if (k != result.size()-1)
                writer.write(result.get(k)+",");
            else
                writer.write(result.get(k));
        }
        writer.close();
    }
}
