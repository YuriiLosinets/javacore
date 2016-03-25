package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
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
        while (reader.ready())
        {
            int i = reader.read();
            if (i == 46) i = 33;
            writer.write(i);
        }
        consolereader.close();
        reader.close();
        writer.close();
    }
}
