package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
        File fileForRead = new File(consolereader.readLine());
        File fileForWrite = new File(consolereader.readLine());
        FileReader reader = new FileReader(fileForRead);
        FileWriter writer = new FileWriter(fileForWrite);
        String line = "";
        while (reader.ready())
        {
            int i = reader.read();
            char c = (char) i;
            line = line + c;
        }
        String[] array = line.split(" ");
        for (int i = 0; i < array.length; i++)
            if (array[i].matches("[0-9]+"))
                writer.write(array[i] + " ");
        consolereader.close();
        reader.close();
        writer.close();
    }
}
