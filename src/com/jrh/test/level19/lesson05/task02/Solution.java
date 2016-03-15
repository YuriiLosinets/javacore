package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(consolereader.readLine());
        FileReader reader = new FileReader(file);
        String bigline = "";
        while (reader.ready())
        {
            int i = reader.read();
            char c = (char) i;
            bigline = bigline + c;
        }
        bigline = bigline.toLowerCase();
        String[] array = bigline.split("[\\p{Punct}\\s]+");
        int count = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i].equals("world")) count++;
        }
        System.out.println(count);
        consolereader.close();
        reader.close();
    }
}
