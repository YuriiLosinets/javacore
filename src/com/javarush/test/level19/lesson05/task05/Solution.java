package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
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
        String bigline = "";
        while (reader.ready())
        {
            int i = reader.read();
            char c = (char) i;
            bigline = bigline + c;
        }
        bigline = bigline.replaceAll("[\\p{Punct}\\s\\n]+", "");
        writer.write(bigline);
        consolereader.close();
        reader.close();
        writer.close();
    }
}
