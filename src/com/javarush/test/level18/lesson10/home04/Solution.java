package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream inputStream1 = new FileInputStream(file1);
        FileInputStream inputStream2 = new FileInputStream(file2);
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        while (inputStream1.available()>0)
        {
            list1.add(inputStream1.read());
        }
        while (inputStream2.available()>0)
        {
            list2.add(inputStream2.read());
        }
        reader.close();
        inputStream1.close();
        inputStream2.close();
        FileOutputStream outputStream1 = new FileOutputStream(file1);
        for (int i : list2)
        {
            outputStream1.write(i);
        }
        for (int i : list1)
        {
            outputStream1.write(i);
        }
        outputStream1.close();
    }
}
