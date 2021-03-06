package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
        List<Integer> list = new ArrayList<Integer>();
        while (inputStream.available() > 0)
        {
            int i = inputStream.read();
            list.add(i);
        }
        Collections.reverse(list);
        for (int i : list)
        {
            outputStream.write(i);
        }
        reader.close();
        inputStream.close();
        outputStream.close();
    }
}
